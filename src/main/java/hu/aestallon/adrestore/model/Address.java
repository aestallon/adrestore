package hu.aestallon.adrestore.model;

import hu.aestallon.adrestore.rest.model.AddressDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "address_id")
  private Integer id;

  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL)
  private List<AddressItem> items = new ArrayList<>();

  public Address items(List<AddressItem> items) {
    for (var item : items) {
      this.items.add(item);
      item.setAddress(this);
    }
    return this;
  }

  public static Address fromDto(AddressDetail addressDetail) {
    final String street = addressDetail.getStreet();
    final int lastSpace = street.lastIndexOf(' ');

    final String streetName;
    final String streetType;
    if (lastSpace > 0) {
      streetName = street.substring(0, lastSpace);
      streetType = street.substring(lastSpace + 1);
    } else {
      streetName = street;
      streetType = null;
    }

    final Address a = new Address().items(List.of(
        AddressItem.builder()
            .kind(AddressItemKind.COUNTRY)
            .value(addressDetail.getCountry())
            .build(),
        AddressItem.builder()
            .kind(AddressItemKind.TOWN)
            .value(addressDetail.getTown())
            .build(),
        AddressItem.builder()
            .kind(AddressItemKind.STREET_NAME)
            .value(streetName)
            .build(),
        AddressItem.builder()
            .kind(AddressItemKind.STREET_NUM)
            .value(addressDetail.getStreetNo().toString())
            .build()
    ));
    if (streetType != null) {
      a.items(List.of(AddressItem.builder()
          .kind(AddressItemKind.STREET_TYPE)
          .value(streetType)
          .build()));
    }
    a.setId(addressDetail.getId());
    return a;
  }

  public AddressDetail toDto() {
    final var itemsByKind = this.itemsByKind();
    final String street = itemsByKind.containsKey(AddressItemKind.STREET_TYPE)
        ? itemsByKind.get(AddressItemKind.STREET_NAME) + itemsByKind.get(AddressItemKind.STREET_TYPE)
        : itemsByKind.get(AddressItemKind.STREET_NAME);
    return new AddressDetail()
        .id(this.id)
        .country(itemsByKind.get(AddressItemKind.COUNTRY))
        .town(itemsByKind.get(AddressItemKind.TOWN))
        .street(street)
        .streetNo(Integer.valueOf(itemsByKind.get(AddressItemKind.STREET_NUM)));
  }

  public Address mergeWithDto(AddressDetail addressDetail) {
    final Address a2 = Address.fromDto(addressDetail);

    this.mergeProperty(AddressItemKind.COUNTRY, addressDetail.getCountry());
    this.mergeProperty(AddressItemKind.TOWN, addressDetail.getTown());
    this.mergeProperty(AddressItemKind.COUNTRY, addressDetail.getCountry());
    this.mergeProperty(AddressItemKind.STREET_NAME, a2.items.stream()
        .filter(i -> AddressItemKind.STREET_NAME == i.getKind())
        .findFirst()
        .map(AddressItem::getValue)
        .orElse(null));
    this.mergeProperty(AddressItemKind.STREET_TYPE, a2.items.stream()
        .filter(i -> AddressItemKind.STREET_TYPE == i.getKind())
        .findFirst()
        .map(AddressItem::getValue)
        .orElse(null));
    this.mergeProperty(AddressItemKind.STREET_NUM, addressDetail.getStreetNo());

    return this;
  }

  private void mergeProperty( AddressItemKind kind, Object newValue) {
    this.items.stream().filter(i -> kind == i.getKind())
        .findFirst()
        .ifPresentOrElse(
            i -> i.setValue(String.valueOf(newValue)),
            () -> {
              if (newValue == null || String.valueOf(newValue).isBlank()) {
                return;
              }
              this.items(List.of(AddressItem.builder()
                  .kind(kind)
                  .value(String.valueOf(newValue))
                  .build()));
            }
        );
  }

  public Map<AddressItemKind, String> itemsByKind() {
    return this.items.stream()
        .collect(groupingBy(
            AddressItem::getKind,
            mapping(AddressItem::getValue, reducing((s1, s2) -> s1))
        ))
        .entrySet().stream()
        .filter(e -> e.getValue().isPresent())
        .map(e -> Map.entry(e.getKey(), e.getValue().get()))
        .collect(toMap(Map.Entry::getKey, Map.Entry::getValue));
  }
}

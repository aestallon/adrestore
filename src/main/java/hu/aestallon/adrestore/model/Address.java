package hu.aestallon.adrestore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
}

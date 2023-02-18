package hu.aestallon.adrestore.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS_ITEM")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AddressItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "address_item_id")
  private Integer id;

  @ManyToOne
  @JoinColumn(name = "address_id")
  private Address address;

  @Column(name = "kind")
  @Enumerated(EnumType.STRING)
  private AddressItemKind kind;

  @Column(name = "item_value")
  private String value;
}


package hu.aestallon.adrestore.model;

import hu.aestallon.adrestore.rest.model.AddressDetail;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.rest.model.PersonPreview;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Person {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "person_id")
  private Integer id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "last_name")
  private String lastName;

  @ManyToOne
  @JoinColumn(name = "temporary_address_id")
  private Address temporaryAddress;

  @ManyToOne
  @JoinColumn(name = "permanent_address_id")
  private Address permanentAddress;

  public static Person fromDto(PersonDetail personDetail) {
    return new Person(
        personDetail.getId(),
        personDetail.getFirstName(),
        personDetail.getLastName(),
        Address.fromDto(personDetail.getPermanentAddress()),
        Address.fromDto(personDetail.getTemporaryAddress()));
  }

  public PersonPreview toPreview() {
    final String fullName = this.firstName + " " + this.lastName;
    return new PersonPreview()
        .id(this.id)
        .name(fullName);
  }

  public PersonDetail toDetail() {
    return new PersonDetail()
        .id(this.id)
        .firstName(this.firstName)
        .lastName(this.lastName)
        .permanentAddress(initAddressDetail(this.permanentAddress))
        .temporaryAddress(initAddressDetail(this.temporaryAddress));
  }

  private static AddressDetail initAddressDetail(Address a) {
    return (a != null)
        ? a.toDto()
        : new AddressDetail();
  }
}

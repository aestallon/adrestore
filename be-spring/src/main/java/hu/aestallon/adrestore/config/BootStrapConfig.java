package hu.aestallon.adrestore.config;

import hu.aestallon.adrestore.model.Address;
import hu.aestallon.adrestore.model.AddressItem;
import hu.aestallon.adrestore.model.AddressItemKind;
import hu.aestallon.adrestore.model.Person;
import hu.aestallon.adrestore.repository.AddressRepository;
import hu.aestallon.adrestore.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.List;


//@Configuration
@SuppressWarnings("unused")
public class BootStrapConfig {

  //@Bean
  CommandLineRunner initDatabase(PersonRepository personRepository,
                                 AddressRepository addressRepository) {
    return args -> {
      List<AddressItem> addressItems = List.of(
          AddressItem.builder()
              .kind(AddressItemKind.COUNTRY)
              .value("Hungary")
              .build(),
          AddressItem.builder()
              .kind(AddressItemKind.TOWN)
              .value("Budapest")
              .build(),
          AddressItem.builder()
              .kind(AddressItemKind.STREET_NAME)
              .value("Random")
              .build(),
          AddressItem.builder()
              .kind(AddressItemKind.STREET_TYPE)
              .value("Way")
              .build(),
          AddressItem.builder()
              .kind(AddressItemKind.STREET_NUM)
              .value("69")
              .build(),
          AddressItem.builder()
              .kind(AddressItemKind.MOBILE_TEL)
              .value("3012345678")
              .build(),
          AddressItem.builder()
              .kind(AddressItemKind.E_MAIL)
              .value("something@domain.com")
              .build()
      );
      Address address = addressRepository.saveAndFlush(new Address());
      address = addressRepository.saveAndFlush(address.items(addressItems));
      personRepository.save(Person.builder()
          .firstName("John")
          .lastName("Doe")
          .permanentAddress(address)
          .build());
    };
  }
}

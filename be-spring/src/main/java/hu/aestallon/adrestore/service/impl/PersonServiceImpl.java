package hu.aestallon.adrestore.service.impl;

import hu.aestallon.adrestore.model.Address;
import hu.aestallon.adrestore.model.Person;
import hu.aestallon.adrestore.repository.AddressRepository;
import hu.aestallon.adrestore.repository.PersonRepository;
import hu.aestallon.adrestore.rest.model.AddressDetail;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.rest.model.PersonPreview;
import hu.aestallon.adrestore.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

  private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

  private final PersonRepository  personRepository;
  private final AddressRepository addressRepository;

  public PersonServiceImpl(PersonRepository personRepository, AddressRepository addressRepository) {
    this.personRepository = personRepository;
    this.addressRepository = addressRepository;
  }

  @Override
  public PersonDetail create(PersonDetail p) {
    log.debug("Invoked person create: {}", p);
    p.setTemporaryAddress(null);
    p.setPermanentAddress(null);

    Person person = Person.fromDto(p);
    Person savedPerson = personRepository.save(person);
    return savedPerson.toDetail();
  }

  @Override
  public void delete(int id) {
    log.debug("Invoked person delete {}", id);
    personRepository.deleteById(id);
  }

  @Override
  public List<PersonPreview> findAll() {
    return personRepository.findAll().stream()
        .map(Person::toPreview)
        .sorted(Comparator.comparing(PersonPreview::getName))
        .toList();
  }

  @Override
  public Optional<PersonDetail> findById(int id) {
    return personRepository.findById(id).map(Person::toDetail);
  }

  @Override
  public Optional<PersonDetail> updateAddress(int id, AddressDetail permanent,
                                              AddressDetail temporary) {
    log.debug("Update address invoked, id {}, permanent {} temporary {}", id, permanent, temporary);
    return personRepository.findById(id)
        .map(p -> {
          final Address permanentAddress = p.getPermanentAddress();
          p.setPermanentAddress(this.updateAddress(permanentAddress, permanent));

          final Address temporaryAddress = p.getTemporaryAddress();
          p.setTemporaryAddress(this.updateAddress(temporaryAddress, temporary));

          return personRepository.save(p);
        })
        .map(Person::toDetail);
  }

  @Override
  public Optional<PersonDetail> updateName(int id, String firstName, String lastName) {
    return personRepository
        .findById(id)
        .map(p -> {
          p.setFirstName(firstName);
          p.setLastName(lastName);
          return personRepository.save(p);
        })
        .map(Person::toDetail);
  }

  private Address updateAddress(Address original, AddressDetail incoming) {
    if (incoming == null || this.isEmptyAddressDetail(incoming)) {
      return original;
    }
    final Address address = (original == null)
        ? Address.fromDto(incoming)
        : original.mergeWithDto(incoming);
    return addressRepository.save(address);
  }

  private boolean isEmptyAddressDetail(AddressDetail addressDetail) {
    return addressDetail.getCountry() == null && addressDetail.getTown() == null;
  }

}

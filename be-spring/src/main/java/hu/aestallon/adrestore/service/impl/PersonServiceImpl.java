package hu.aestallon.adrestore.service.impl;

import hu.aestallon.adrestore.model.Address;
import hu.aestallon.adrestore.model.AddressItem;
import hu.aestallon.adrestore.model.AddressItemKind;
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
    p.setTemporaryAddress(null);
    p.setPermanentAddress(null);

    Person person = Person.fromDto(p);
    Person savedPerson = personRepository.save(person);
    return savedPerson.toDetail();
  }

  @Override
  public void delete(int id) {
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
    return personRepository.findById(id)
        .map(p -> {
          Address permanentAddress = p.getPermanentAddress();
          if (permanentAddress == null && permanent != null) {
            permanentAddress = Address.fromDto(permanent);
            permanentAddress = addressRepository.save(permanentAddress);
            p.setPermanentAddress(permanentAddress);
          } else if (permanent != null) {
            permanentAddress = permanentAddress.mergeWithDto(permanent);
            permanentAddress = addressRepository.save(permanentAddress);
            p.setPermanentAddress(permanentAddress);
          }

          Address temporaryAddress = p.getTemporaryAddress();
          if (temporaryAddress == null && temporary != null) {
            temporaryAddress = Address.fromDto(temporary);
            temporaryAddress = addressRepository.save(temporaryAddress);
            p.setTemporaryAddress(temporaryAddress);
          } else if (temporary != null) {
            temporaryAddress = temporaryAddress.mergeWithDto(temporary);
            temporaryAddress = addressRepository.save(temporaryAddress);
            p.setTemporaryAddress(temporaryAddress);
          }
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

}

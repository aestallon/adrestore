package hu.aestallon.adrestore.service.impl;

import hu.aestallon.adrestore.repository.AddressRepository;
import hu.aestallon.adrestore.repository.PersonRepository;
import hu.aestallon.adrestore.rest.model.AddressDetail;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

  private final PersonRepository  personRepository;
  private final AddressRepository addressRepository;

  public PersonServiceImpl(PersonRepository personRepository, AddressRepository addressRepository) {
    this.personRepository = personRepository;
    this.addressRepository = addressRepository;
  }

  @Override
  public PersonDetail create(PersonDetail p) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<PersonDetail> findAll() {
    return null;
  }

  @Override
  public Optional<PersonDetail> findById(int id) {
    return Optional.empty();
  }

  @Override
  public Optional<PersonDetail> updateAddress(int id, AddressDetail permanent,
                                              AddressDetail temporary) {
    return Optional.empty();
  }

  @Override
  public Optional<PersonDetail> updateName(int id, String firstName, String lastName) {
    return Optional.empty();
  }

}

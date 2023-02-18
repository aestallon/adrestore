package hu.aestallon.adrestore.service;

import hu.aestallon.adrestore.rest.model.AddressDetail;
import hu.aestallon.adrestore.rest.model.PersonDetail;

import java.util.List;
import java.util.Optional;

public interface PersonService {

  PersonDetail create(PersonDetail p);

  void delete(int id);

  List<PersonDetail> findAll();

  Optional<PersonDetail> findById(int id);

  Optional<PersonDetail> updateAddress(int id, AddressDetail permanent, AddressDetail temporary);

  Optional<PersonDetail> updateName(int id, String firstName, String lastName);

}

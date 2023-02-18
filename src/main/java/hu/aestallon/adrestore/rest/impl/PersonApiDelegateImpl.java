package hu.aestallon.adrestore.rest.impl;

import hu.aestallon.adrestore.rest.api.PersonsApiDelegate;
import hu.aestallon.adrestore.rest.model.PersonAddressUpdate;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.rest.model.PersonNameUpdate;
import hu.aestallon.adrestore.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonApiDelegateImpl implements PersonsApiDelegate {

  private final PersonService personService;

  public PersonApiDelegateImpl(PersonService personService) {
    this.personService = personService;
  }

  @Override
  public ResponseEntity<PersonDetail> createPerson(PersonDetail personDetail) {
    return ResponseEntity.ok(personService.create(personDetail));
  }

  @Override
  public ResponseEntity<Void> deletePerson(Integer personId) {
    personService.delete(personId);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<List<PersonDetail>> getAllPersons() {
    return ResponseEntity.ok(personService.findAll());
  }

  @Override
  public ResponseEntity<PersonDetail> getPersonById(Integer personId) {
    return personService.findById(personId)
        .map(ResponseEntity::ok)
        .orElseGet(ResponseEntity.notFound()::build);
  }

  @Override
  public ResponseEntity<PersonDetail> updatePersonAddress(Integer personId,
                                                          PersonAddressUpdate personAddressUpdate) {
    return personService
        .updateAddress(
            personId,
            personAddressUpdate.getPermanentAddress(),
            personAddressUpdate.getTemporaryAddress()
        )
        .map(ResponseEntity::ok)
        .orElseGet(ResponseEntity.notFound()::build);
  }

  @Override
  public ResponseEntity<PersonDetail> updatePersonName(Integer personId,
                                                       PersonNameUpdate personNameUpdate) {
    return personService.updateName(
            personId,
            personNameUpdate.getFirstName(),
            personNameUpdate.getLastName()
        )
        .map(ResponseEntity::ok)
        .orElseGet(ResponseEntity.notFound()::build);
  }

}

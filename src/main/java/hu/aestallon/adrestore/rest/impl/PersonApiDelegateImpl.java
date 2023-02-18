package hu.aestallon.adrestore.rest.impl;

import hu.aestallon.adrestore.rest.api.PersonsApiDelegate;
import hu.aestallon.adrestore.rest.model.PersonAddressUpdate;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.rest.model.PersonNameUpdate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PersonApiDelegateImpl implements PersonsApiDelegate {

  @Override
  public ResponseEntity<PersonDetail> createPerson(PersonDetail personDetail) {
    return PersonsApiDelegate.super.createPerson(personDetail);
  }

  @Override
  public ResponseEntity<Void> deletePerson(Integer personId) {
    return PersonsApiDelegate.super.deletePerson(personId);
  }

  @Override
  public ResponseEntity<List<PersonDetail>> getAllPersons() {
    return PersonsApiDelegate.super.getAllPersons();
  }

  @Override
  public ResponseEntity<PersonDetail> getPersonById(Integer personId) {
    return PersonsApiDelegate.super.getPersonById(personId);
  }

  @Override
  public ResponseEntity<PersonDetail> personsIdAddressesPut(Integer id, String authorization,
                                                            PersonAddressUpdate personAddressUpdate) {
    return PersonsApiDelegate.super.personsIdAddressesPut(id, authorization, personAddressUpdate);
  }

  @Override
  public ResponseEntity<PersonDetail> personsPersonIdPut(Integer personId,
                                                         PersonNameUpdate personNameUpdate) {
    return PersonsApiDelegate.super.personsPersonIdPut(personId, personNameUpdate);
  }

}

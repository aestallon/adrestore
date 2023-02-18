package hu.aestallon.adrestore.rest.api;

import hu.aestallon.adrestore.rest.model.PersonAddressUpdate;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.rest.model.PersonNameUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

/**
 * A delegate to be called by the {@link PersonsApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public interface PersonsApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /persons : Create a new person
     *
     * @param personDetail Person object to be created (required)
     * @return The created person (status code 201)
     * @see PersonsApi#createPerson
     */
    default ResponseEntity<PersonDetail> createPerson(PersonDetail personDetail) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"temporaryAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" }, \"id\" : 0, \"permanentAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * DELETE /persons/{personId} : Delete a person by ID
     *
     * @param personId ID of person to delete (required)
     * @return The person was successfully deleted (status code 204)
     * @see PersonsApi#deletePerson
     */
    default ResponseEntity<Void> deletePerson(Integer personId) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /persons : Retrieve all persons
     *
     * @return A list of persons (status code 200)
     * @see PersonsApi#getAllPersons
     */
    default ResponseEntity<List<PersonDetail>> getAllPersons() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"temporaryAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" }, \"id\" : 0, \"permanentAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * GET /persons/{personId} : Retrieve a person by ID
     *
     * @param personId ID of person to return (required)
     * @return The requested person (status code 200)
     * @see PersonsApi#getPersonById
     */
    default ResponseEntity<PersonDetail> getPersonById(Integer personId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"temporaryAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" }, \"id\" : 0, \"permanentAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /persons/{id}/addresses : Update a person&#39;s addresses
     *
     * @param id ID of the person to update (required)
     * @param authorization Bearer token for authentication (required)
     * @param personAddressUpdate Updated addresses of the person (required)
     * @return Person addresses updated successfully (status code 200)
     * @see PersonsApi#personsIdAddressesPut
     */
    default ResponseEntity<PersonDetail> personsIdAddressesPut(Integer id,
        String authorization,
        PersonAddressUpdate personAddressUpdate) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"temporaryAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" }, \"id\" : 0, \"permanentAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * PUT /persons/{personId} : Update a person&#39;s name
     *
     * @param personId ID of the person to update (required)
     * @param personNameUpdate Updated name of the person (required)
     * @return Person name updated successfully (status code 200)
     * @see PersonsApi#personsPersonIdPut
     */
    default ResponseEntity<PersonDetail> personsPersonIdPut(Integer personId,
        PersonNameUpdate personNameUpdate) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"firstName\" : \"firstName\", \"lastName\" : \"lastName\", \"temporaryAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" }, \"id\" : 0, \"permanentAddress\" : { \"country\" : \"country\", \"town\" : \"town\", \"streetNo\" : 6, \"street\" : \"street\" } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

package hu.aestallon.adrestore.rest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import hu.aestallon.adrestore.rest.model.AddressDetail;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * PersonDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PersonDetail {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("firstName")
  private String firstName;

  @JsonProperty("lastName")
  private String lastName;

  @JsonProperty("permanentAddress")
  private AddressDetail permanentAddress;

  @JsonProperty("temporaryAddress")
  private AddressDetail temporaryAddress;

  public PersonDetail id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public PersonDetail firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
  */
  
  @Schema(name = "firstName", required = false)
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public PersonDetail lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
  */
  
  @Schema(name = "lastName", required = false)
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public PersonDetail permanentAddress(AddressDetail permanentAddress) {
    this.permanentAddress = permanentAddress;
    return this;
  }

  /**
   * Get permanentAddress
   * @return permanentAddress
  */
  @Valid 
  @Schema(name = "permanentAddress", required = false)
  public AddressDetail getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(AddressDetail permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  public PersonDetail temporaryAddress(AddressDetail temporaryAddress) {
    this.temporaryAddress = temporaryAddress;
    return this;
  }

  /**
   * Get temporaryAddress
   * @return temporaryAddress
  */
  @Valid 
  @Schema(name = "temporaryAddress", required = false)
  public AddressDetail getTemporaryAddress() {
    return temporaryAddress;
  }

  public void setTemporaryAddress(AddressDetail temporaryAddress) {
    this.temporaryAddress = temporaryAddress;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PersonDetail personDetail = (PersonDetail) o;
    return Objects.equals(this.id, personDetail.id) &&
        Objects.equals(this.firstName, personDetail.firstName) &&
        Objects.equals(this.lastName, personDetail.lastName) &&
        Objects.equals(this.permanentAddress, personDetail.permanentAddress) &&
        Objects.equals(this.temporaryAddress, personDetail.temporaryAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, permanentAddress, temporaryAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonDetail {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    permanentAddress: ").append(toIndentedString(permanentAddress)).append("\n");
    sb.append("    temporaryAddress: ").append(toIndentedString(temporaryAddress)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


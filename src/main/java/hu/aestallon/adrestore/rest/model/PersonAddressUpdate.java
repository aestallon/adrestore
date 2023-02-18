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
 * PersonAddressUpdate
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class PersonAddressUpdate {

  @JsonProperty("permanentAddress")
  private AddressDetail permanentAddress;

  @JsonProperty("temporaryAddress")
  private AddressDetail temporaryAddress;

  public PersonAddressUpdate permanentAddress(AddressDetail permanentAddress) {
    this.permanentAddress = permanentAddress;
    return this;
  }

  /**
   * Get permanentAddress
   * @return permanentAddress
  */
  @NotNull @Valid 
  @Schema(name = "permanentAddress", required = true)
  public AddressDetail getPermanentAddress() {
    return permanentAddress;
  }

  public void setPermanentAddress(AddressDetail permanentAddress) {
    this.permanentAddress = permanentAddress;
  }

  public PersonAddressUpdate temporaryAddress(AddressDetail temporaryAddress) {
    this.temporaryAddress = temporaryAddress;
    return this;
  }

  /**
   * Get temporaryAddress
   * @return temporaryAddress
  */
  @NotNull @Valid 
  @Schema(name = "temporaryAddress", required = true)
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
    PersonAddressUpdate personAddressUpdate = (PersonAddressUpdate) o;
    return Objects.equals(this.permanentAddress, personAddressUpdate.permanentAddress) &&
        Objects.equals(this.temporaryAddress, personAddressUpdate.temporaryAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(permanentAddress, temporaryAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PersonAddressUpdate {\n");
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


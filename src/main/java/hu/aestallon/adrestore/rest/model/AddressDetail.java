package hu.aestallon.adrestore.rest.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * AddressDetail
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
public class AddressDetail {

  @JsonProperty("country")
  private String country;

  @JsonProperty("town")
  private String town;

  @JsonProperty("street")
  private String street;

  @JsonProperty("streetNo")
  private Integer streetNo;

  public AddressDetail country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
  */
  
  @Schema(name = "country", required = false)
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public AddressDetail town(String town) {
    this.town = town;
    return this;
  }

  /**
   * Get town
   * @return town
  */
  
  @Schema(name = "town", required = false)
  public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public AddressDetail street(String street) {
    this.street = street;
    return this;
  }

  /**
   * Get street
   * @return street
  */
  
  @Schema(name = "street", required = false)
  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public AddressDetail streetNo(Integer streetNo) {
    this.streetNo = streetNo;
    return this;
  }

  /**
   * Get streetNo
   * @return streetNo
  */
  
  @Schema(name = "streetNo", required = false)
  public Integer getStreetNo() {
    return streetNo;
  }

  public void setStreetNo(Integer streetNo) {
    this.streetNo = streetNo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AddressDetail addressDetail = (AddressDetail) o;
    return Objects.equals(this.country, addressDetail.country) &&
        Objects.equals(this.town, addressDetail.town) &&
        Objects.equals(this.street, addressDetail.street) &&
        Objects.equals(this.streetNo, addressDetail.streetNo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, town, street, streetNo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AddressDetail {\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    town: ").append(toIndentedString(town)).append("\n");
    sb.append("    street: ").append(toIndentedString(street)).append("\n");
    sb.append("    streetNo: ").append(toIndentedString(streetNo)).append("\n");
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


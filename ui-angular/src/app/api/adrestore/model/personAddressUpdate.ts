/**
 * AdreStore API
 * A simple CRUD API for an example Address Store
 *
 * The version of the OpenAPI document: 1.0.0
 * Contact: papp.szabolcs.bazil@gmail.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { AddressDetail } from './addressDetail';


export interface PersonAddressUpdate { 
    permanentAddress: AddressDetail;
    temporaryAddress: AddressDetail;
}


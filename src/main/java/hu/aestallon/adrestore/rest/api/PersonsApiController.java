package hu.aestallon.adrestore.rest.api;

import hu.aestallon.adrestore.rest.model.PersonAddressUpdate;
import hu.aestallon.adrestore.rest.model.PersonDetail;
import hu.aestallon.adrestore.rest.model.PersonNameUpdate;
import hu.aestallon.adrestore.rest.model.PersonPreview;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen")
@Controller
@RequestMapping("${openapi.adreStore.base-path:}")
public class PersonsApiController implements PersonsApi {

    private final PersonsApiDelegate delegate;

    public PersonsApiController(@Autowired(required = false) PersonsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new PersonsApiDelegate() {});
    }

    @Override
    public PersonsApiDelegate getDelegate() {
        return delegate;
    }

}

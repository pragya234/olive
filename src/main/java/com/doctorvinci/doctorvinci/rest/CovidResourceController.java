package com.doctorvinci.doctorvinci.rest;

import com.doctorvinci.doctorvinci.models.CovidResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

 @RestController
 @RequestMapping(value = "covid")
 public class CovidResourceController {

  /*
 1. updating covid related data sent by hospital
 2. update no. of beds in hospital
  api @
 3. get hospital available for covid
 4. get oxygen availability in a particular city
 5. api- @GetMapping(value=/{cityName}/)
   */

 ResponseEntity<List<CovidResource>>availableCovidResources(){
    return  null;
  }
 }

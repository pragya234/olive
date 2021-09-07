package com.olive.olive.rest;

import com.olive.olive.models.HomePage;
import com.olive.olive.service.HomePageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "homepage")
public class HomePageController {
  private final HomePageService homePageService;
  // instance variable, cant be accessed without creating object
  public HomePageController(HomePageService homePageService) {

    this.homePageService = homePageService; // homePageController ka object, jisme homepage service
    // variable pass hua hai usko home page service ka object assign kar dete hain
  }
  /*
  this ka matlab hota hai current object, jab bhi koi homepagecontroller ka object
  banayega tab vo homepageservice ka ek object pass karega. ab kyunki hamne homepageservice ka object level variable
  declare kiya hai, to hume use assign karna chahiye that only we are doing inside the constructor
  */
  @GetMapping(value = "/{city}")
  public ResponseEntity<HomePage> getHomepage(
      @PathVariable(value = "city") String city,
      @RequestParam(value = "latitude", required = false) double latitude,
      @RequestParam(value = "longitude", required = false) double longitude) {
    HomePage homePage = homePageService.getHomepage(city, latitude, longitude);
    return ResponseEntity.ok(homePage);
  }
}

/*https://meet.google.com/ccr-ckdi-obj?pli=1&authuser=1
url: https://meet.google.com/
path: ccr-ckdi-obj
requestparam/queryparam: pli=1&authuser=1

localhost:9027/homepage/nearbyhospital/muzaffarpur?longitude=87.09&latitude=32.5
 */
// this will serve homepage for all the user types
// what all departments(speciality) we have in that city,
// any nearby 10 doctors,
// any nearby 10 hospitals,
  /*pagination(database concept for sending records page wise, we don't want to send all the records at once),
  let's suppose, there are 100 doctors in a city and we want to send it to frontend in a batch of 10,
  so what frontend will do, it will ask for records of page size=10 and offset=10>the last offset.
  if there will be no offset then it will make the offset as 0
  1st call: page size 10, offset o
  2nd call: page size 10, offset 10
  and so on*/

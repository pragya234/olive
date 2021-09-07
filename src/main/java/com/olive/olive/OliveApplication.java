package com.olive.olive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OliveApplication {

  public static void main(String[] args) {
    SpringApplication.run(OliveApplication.class, args);
  }
}
/*
library: set of code which provides some functionality and which is used inside our application and
our code calls the library method eg: JDBC, String.valueOf()
framework: framework is a set of code which provides some functionality and which call our code to do
something like @RestController
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetailsEntity, Integer>


 */

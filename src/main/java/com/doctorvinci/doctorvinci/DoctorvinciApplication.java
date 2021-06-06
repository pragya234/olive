package com.doctorvinci.doctorvinci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorvinciApplication {

  public static void main(String[] args) {
    SpringApplication.run(DoctorvinciApplication.class, args);
  }
}
/*
library: set of code which provides some functionality and which is used inside our application and
our code calls the library method eg: JDBC, String.valueOf()
framework: framework is a set of code which provides some functionality and which call our code to do
something like @RestController
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetailsEntity, Integer>


 */

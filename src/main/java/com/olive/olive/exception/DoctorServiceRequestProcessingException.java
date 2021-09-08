package com.olive.olive.exception;
// this is a custom exception class which extends exception
public class DoctorServiceRequestProcessingException extends Exception {
  public DoctorServiceRequestProcessingException(String message) {
    super(
        message); // Super me msg pass karna is calling constructor of parent class which is yha par
    // Exception class
  }
}

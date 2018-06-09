package com.example.restfulwebservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
  private static final long serialVersionUID = -9044391477402925045L;

  public UserNotFoundException(String message) {
    super(message);
  }
}

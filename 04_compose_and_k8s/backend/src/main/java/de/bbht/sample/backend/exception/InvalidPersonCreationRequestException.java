package de.bbht.sample.backend.exception;

public class InvalidPersonCreationRequestException extends RuntimeException {

  public InvalidPersonCreationRequestException(String message) {
    super(message);
  }
}

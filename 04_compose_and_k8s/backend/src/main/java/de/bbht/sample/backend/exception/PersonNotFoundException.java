package de.bbht.sample.backend.exception;

import java.util.UUID;
import lombok.Getter;

@Getter
public class PersonNotFoundException extends RuntimeException {
  private final UUID causingId;

  public PersonNotFoundException(UUID causingId) {
    this.causingId = causingId;
  }
}

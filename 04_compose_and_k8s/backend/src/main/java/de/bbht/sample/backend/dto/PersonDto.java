package de.bbht.sample.backend.dto;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Data;

@Data
public class PersonDto {

  private UUID id;
  private String firstName;
  private String lastname;
  private LocalDate birthDate;
}

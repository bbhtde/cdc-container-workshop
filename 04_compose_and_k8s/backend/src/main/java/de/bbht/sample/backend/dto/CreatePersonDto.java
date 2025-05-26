package de.bbht.sample.backend.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CreatePersonDto {

  private String firstName;
  private String lastname;
  private LocalDate birthDate;
}

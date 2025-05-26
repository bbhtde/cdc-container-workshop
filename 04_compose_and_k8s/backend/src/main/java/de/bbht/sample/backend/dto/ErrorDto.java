package de.bbht.sample.backend.dto;

import lombok.Data;

@Data
public class ErrorDto {

  private Long code;
  private String description;
}

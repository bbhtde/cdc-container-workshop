package de.bbht.sample.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "person")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonJpa {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String firstName;
  private String lastname;
  private LocalDate birthDate;
}

package de.bbht.sample.backend.service;

import de.bbht.sample.backend.dto.CreatePersonDto;
import de.bbht.sample.backend.dto.PersonDto;
import de.bbht.sample.backend.exception.InvalidPersonCreationRequestException;
import de.bbht.sample.backend.exception.PersonNotFoundException;
import de.bbht.sample.backend.mapper.PersonMapper;
import de.bbht.sample.backend.model.PersonJpa;
import de.bbht.sample.backend.repository.PersonJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PersonService {

  private final PersonJpaRepository personJpaRepository;
  private final PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

  public List<PersonDto> getAllPersons() {
    List<PersonDto> result = personJpaRepository.findAll()
        .stream()
        .map(personMapper::toDto)
        .toList();
    log.info("retrieved {} persons", result.size());
    return result;
  }

  public PersonDto getPersonById(UUID id) {
    Optional<PersonJpa> optionalPerson = personJpaRepository.findById(id);
    if (optionalPerson.isPresent()) {
      log.info("person with id {} retrieved", id);
      return personMapper.toDto(optionalPerson.get());
    }
    log.warn("person with id {} could not be found", id);
    throw new PersonNotFoundException(id);
  }

  public PersonDto createPerson(CreatePersonDto createPersonDto) {
    verifyRequest(createPersonDto);
    PersonJpa personToCreate = personMapper.toJpa(createPersonDto);
    PersonJpa createdPerson = personJpaRepository.save(personToCreate);
    log.info("person with id {} was created successfully", createdPerson.getId());
    return personMapper.toDto(createdPerson);
  }

  private void verifyRequest(CreatePersonDto createPersonDto) {
    if (createPersonDto.getFirstName() == null)
      throw new InvalidPersonCreationRequestException("Firstname is required");
    if (createPersonDto.getLastname() == null)
      throw new InvalidPersonCreationRequestException("Lastname is required");
    if (createPersonDto.getBirthDate() == null)
      throw new InvalidPersonCreationRequestException("Birthdate is required");
  }
}

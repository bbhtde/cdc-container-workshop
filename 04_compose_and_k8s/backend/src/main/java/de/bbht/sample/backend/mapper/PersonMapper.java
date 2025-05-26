package de.bbht.sample.backend.mapper;

import de.bbht.sample.backend.dto.CreatePersonDto;
import de.bbht.sample.backend.dto.PersonDto;
import de.bbht.sample.backend.model.PersonJpa;
import org.mapstruct.Mapper;

@Mapper
public interface PersonMapper {

  PersonDto toDto(PersonJpa jpa);

  PersonJpa toJpa(CreatePersonDto dto);
}

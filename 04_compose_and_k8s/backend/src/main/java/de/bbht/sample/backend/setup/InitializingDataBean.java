package de.bbht.sample.backend.setup;

import com.github.javafaker.Faker;
import de.bbht.sample.backend.dto.CreatePersonDto;
import de.bbht.sample.backend.service.PersonService;
import java.time.LocalDate;
import java.time.ZoneId;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
public class InitializingDataBean implements InitializingBean {

  private static final Long TESTDATA_AMOUNT = 10L;
  private static final Faker FAKER = new Faker();
  private final PersonService personService;

  @Override
  public void afterPropertiesSet() throws Exception {
    log.info("Initializing testdata - creating {} persons", TESTDATA_AMOUNT);
    for (int i = 0; i < TESTDATA_AMOUNT; i++) {
      CreatePersonDto createPersonDto = new CreatePersonDto();
      createPersonDto.setFirstName(FAKER.name()
          .firstName());
      createPersonDto.setLastname(FAKER.name()
          .lastName());
      createPersonDto.setBirthDate(LocalDate.ofInstant(FAKER.date()
          .birthday()
          .toInstant(), ZoneId.systemDefault()));
      personService.createPerson(createPersonDto);
    }
  }
}

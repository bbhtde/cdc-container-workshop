package de.bbht.sample.backend.http;

import de.bbht.sample.backend.dto.CreatePersonDto;
import de.bbht.sample.backend.dto.PersonDto;
import de.bbht.sample.backend.service.PersonService;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class PersonHttpController {

  private final PersonService personService;

  @GetMapping
  public ResponseEntity<List<PersonDto>> getAllPersons() throws InterruptedException{
    Thread.sleep(500);
    return ResponseEntity.ok(personService.getAllPersons());
  }

  @GetMapping("/{id}")
  public ResponseEntity<PersonDto> getPersonById(
      @PathVariable("id")
      UUID uuid) throws InterruptedException {
    Thread.sleep(500);
    return ResponseEntity.ok(personService.getPersonById(uuid));
  }

  @PostMapping("/")
  public ResponseEntity<PersonDto> createPerson(
      @RequestBody
      CreatePersonDto createPersonDto) throws InterruptedException {
    Thread.sleep(500);
    PersonDto createdPerson = personService.createPerson(createPersonDto);
    URI uri = URI.create("http://localhost:8080/api/persons/" + createdPerson.getId());
    return ResponseEntity.created(uri)
        .body(createdPerson);
  }
}

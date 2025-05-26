package de.bbht.sample.backend.http;

import de.bbht.sample.backend.dto.ErrorDto;
import de.bbht.sample.backend.exception.InvalidPersonCreationRequestException;
import de.bbht.sample.backend.exception.PersonNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@CrossOrigin(origins = "http://localhost:3000")
public class ExceptionHttpController {

  @ExceptionHandler(PersonNotFoundException.class)
  public ResponseEntity<ErrorDto> handlePersonNotFoundException(PersonNotFoundException exception) {
    final ErrorDto dto = new ErrorDto();
    dto.setCode(404L);
    dto.setDescription("Person with id " + exception.getCausingId() + " could not be found");
    return ResponseEntity.status(404)
        .body(dto);
  }

  @ExceptionHandler(InvalidPersonCreationRequestException.class)
  public ResponseEntity<ErrorDto> handleInvalidPersonCreationRequestException(InvalidPersonCreationRequestException exception) {
    final ErrorDto dto = new ErrorDto();
    dto.setCode(400L);
    dto.setDescription(exception.getMessage());
    return ResponseEntity.badRequest().body(dto);
  }
}

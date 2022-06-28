package group.redisforcache.webapi;

import group.redisforcache.feature.model.Person;
import group.redisforcache.feature.service.PersonService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "person", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController("PersonApi")
@RequiredArgsConstructor
public class PersonApi {

  private final PersonService service;

  @SneakyThrows
  @GetMapping("/get-list")
  public List<Person> getList(){
    return service.getList();
  }

  @SneakyThrows
  @PostMapping("/add")
  public Person add(@RequestBody Person person) { //requestBody 어노테이션 뺴놓지 말기!
    return service.save(person);
  }

  }

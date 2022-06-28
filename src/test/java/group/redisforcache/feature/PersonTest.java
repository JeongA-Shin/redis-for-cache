package group.redisforcache.feature;

import group.redisforcache.feature.model.Person;
import group.redisforcache.feature.repository.PersonRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@WebAppConfiguration
public class PersonTest {

//  @Autowired
//  private PersonRepository repository;
//
//  @Test
//  public void sandbox(){
//
//    Person person = Person.builder().name("test").age("20").build();
//
//    //저장
//    repository.save(person);
//
//    //조회
//    System.out.println(repository.findById(person.getId()));
//
//    //// Person Entity 의 @RedisHash 에 정의되어 있는 keyspace (people) 에 속한 키의 갯수를 구함
//    //System.out.println(repository.count());
//
//  }

}

package group.redisforcache.feature.service;

import group.redisforcache.feature.model.Person;
import group.redisforcache.feature.repository.PersonRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PersonService {

  private final PersonRepository repository;

  // DB 조회 횟수
  private static int dbCount = 0;
  private int age = 20;

  /**
   * 등록
   * @param person
   * @return
   */
  public Person save(Person person){
//    person.setName("test");
//    person.setAge(String.valueOf(age));
//    age++;
    return repository.save(person);
  }

  /*
  전체 조회
   */
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  public List<Person> getList(){
    dbCount++;
    System.out.println(">>>>>>> dbCount: "+dbCount);
    return repository.findAll();
  }

}

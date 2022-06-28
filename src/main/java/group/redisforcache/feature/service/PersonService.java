package group.redisforcache.feature.service;

import group.redisforcache.feature.model.Person;
import group.redisforcache.feature.repository.PersonRepository;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

// https://kheri.net/java-spring-cacheable-annotation/#6_Cache_key_on_no_parameter_method 캐시 키 생성

@Service
@Transactional
@RequiredArgsConstructor
@Data
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
  @CacheEvict(value = "Person",allEntries=true) //@CacheEvict(value = "Person",allEntries=true) //key값 상관없이 해당 value로 들어간 모든 캐시데이터를 지우는 것
  public Person save(Person person){
    return repository.save(person);
  }

  /*
  전체 조회
   */
  @Cacheable(value = "Person") //value는 캐시의 이름, 키는 각 캐시의 id  // ex) Person 캐시에 id(1)에 해당하는 값이 있는지 확인
  @Transactional(readOnly = true, isolation = Isolation.READ_UNCOMMITTED)
  public List<Person> getList(){
    dbCount++;
    System.out.println(">>>>>>> dbCount: "+dbCount);
    return (List<Person>) repository.findAll();
  }

}

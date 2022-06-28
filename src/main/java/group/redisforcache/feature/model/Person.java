package group.redisforcache.feature.model;

import group.redisforcache.feature.model.common.RegMod;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
public class Person { //extends RegMod  //extends RegMod implements Serializable

  //public static final long serialVersionUID = 42L;
  /**
   * serialVersionUID를 지정해주지 않으면 정말 큰일납니다
   *
   * 왜냐하면, 다른 시스템끼리 통신해서 직렬화/역직렬화를 진행하는데
   *
   * 같은 객체라도 serialVersion이 다르면 역직렬화시 다른 객체로 판단해버리기 때문입니다!
   */

  @Id
  //@Id 어노테이션이 붙은 필드가 Redis Key 값이 되며 null 로 세팅하면 랜덤값이 설정됨 //keyspace 와 합쳐져서 레디스에 저장된 최종 키 값은 keyspace:id가 됨
  @GeneratedValue(strategy = GenerationType.AUTO) //db에서 자동으로 생성되도록 해준다
  @Column(name = "id",columnDefinition = "BINARY(16)", nullable = false)
  private UUID id;

  @Column(name="name")
  private String name;

  @Column(name="age")
  private String age;

}

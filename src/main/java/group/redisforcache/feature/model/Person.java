package group.redisforcache.feature.model;

import group.redisforcache.feature.model.common.RegMod;
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
@EqualsAndHashCode(callSuper = true)
public class Person extends RegMod {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) //db에서 자동으로 생성되도록 해준다
  @Column(name = "id",columnDefinition = "BINARY(16)", nullable = false)
  private UUID id;

  @Column(name="name")
  private String name;

  @Column(name="age")
  private String age;

}

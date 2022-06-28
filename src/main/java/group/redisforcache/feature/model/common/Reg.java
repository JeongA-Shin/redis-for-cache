package group.redisforcache.feature.model.common;

import java.util.UUID;
import org.joda.time.DateTime;

public interface Reg {

  /**
   * 등록자 식별 번호
   */
  //UUID getRegId();

  /**
   * 등록 일시
   */
  DateTime getRegDt();

}

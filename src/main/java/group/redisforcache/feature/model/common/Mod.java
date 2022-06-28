package group.redisforcache.feature.model.common;

import java.util.UUID;
import org.joda.time.DateTime;

public interface Mod {

  /**
   * 수정자식별번호
   */
  //UUID getModId();

  /**
   * 수정일시
   */
  DateTime getModDt();

}

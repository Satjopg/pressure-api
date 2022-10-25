package jp.satjopg.api.infrastructure.client.zutool;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import jp.satjopg.api.infrastructure.client.zutool.interfaces.ZutoolModel;
import jp.satjopg.api.infrastructure.client.zutool.interfaces.ZutoolModelFactory;
import org.springframework.stereotype.Component;

@Component
class ZutoolApiModelFactory implements ZutoolModelFactory<ZutoolApiResponse> {

  private static final DateTimeFormatter REQUEST_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("uuuu-MM-dd HH");
  private static final ZoneId ZONE_ID = ZoneId.of("Asia/Tokyo");

  public ZutoolModel create (final ZutoolApiResponse response) {
    return new ZutoolModel(
        response.getPlaceName(),
        response.getPrefecturesId(),
        response.getPlaceId(),
        ZonedDateTime.of(
            LocalDateTime.from(REQUEST_DATE_TIME_FORMATTER.parse(response.getDateTime())),
            ZONE_ID)
    );
  }
}

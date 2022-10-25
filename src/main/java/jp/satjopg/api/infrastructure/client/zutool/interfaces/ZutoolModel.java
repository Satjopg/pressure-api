package jp.satjopg.api.infrastructure.client.zutool.interfaces;

import java.time.ZonedDateTime;

public record ZutoolModel (
    String placeName,
    String prefecturesId,
    String placeId,
    ZonedDateTime requestDateTime
) {

  /**
   * @return 地点IDの文字列
   */
  public String locationId () {
    return prefecturesId + placeId;
  }
}

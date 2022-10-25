package jp.satjopg.api.value;

import java.util.Objects;
import lombok.AccessLevel;
import org.springframework.lang.NonNull;

// ある地点の緯度経度
// 緯度と経度と概念を分解できるのでそれぞれクラス化してもよい。
@lombok.RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationPoint {

  private static final Double MIN_LONGITUDE = -180.0;
  private static final Double MAX_LONGITUDE = 180.0;
  private static final Double MIN_LATITUDE = -90.0;
  private static final Double MAX_LATITUDE = 90.0;

  @NonNull
  private final Double latitude;
  @NonNull
  private final Double longitude;


  /**
   * 緯度経度オブジェクトを作成する
   * @param longitude 緯度
   * @param latitude 経度
   * @return 緯度経度オブジェクト
   */
  public static LocationPoint of (final Double longitude, final Double latitude) {
    if (Objects.isNull(longitude) || Objects.isNull(latitude)) {
      throw new IllegalArgumentException("緯度, 経度はどちらも必須です");
    }
    if (latitude < MIN_LATITUDE || latitude > MAX_LATITUDE) {
      throw new IllegalArgumentException("緯度は%.0fから%.0fの値を指定してください. 指定された緯度: %.3f ".formatted(MIN_LATITUDE, MAX_LATITUDE, latitude));
    }
    if (longitude < MIN_LONGITUDE || longitude > MAX_LONGITUDE) {
      throw new IllegalArgumentException("経度は%.0fから%.0fの値を指定してください. 指定された経度: %.3f".formatted(MIN_LONGITUDE, MAX_LONGITUDE, longitude));
    }
    return new LocationPoint(latitude, longitude);
  }

  /**
   * 緯度の値を取得する
   * @return 緯度の値
   */
  public Double longitude () {
    return this.longitude;
  }

  /**
   * 経度の値を取得する
   * @return 経度の値
   */
  public Double latitude () {
    return this.latitude;
  }
}

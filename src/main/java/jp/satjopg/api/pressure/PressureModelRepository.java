package jp.satjopg.api.pressure;

import jp.satjopg.api.value.LocationPoint;

interface PressureModelRepository {

  /**
   * 指定した緯度経度の気圧値を取得する
   *
   * @param locationPoint 緯度経度
   * @return {@link PressureModel}
   */
  PressureModel fetch (final LocationPoint locationPoint);
}

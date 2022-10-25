package jp.satjopg.api.infrastructure.client.weather;

import jp.satjopg.api.value.LocationPoint;

// WeatherMapAPIを外部クラスが利用するための公開IF
// 実体はDIされるので利用したいクラスはこのIFだけ気にすれば良い
public interface WeatherApiClient {

  /**
   * 指定した地点に対する天気に関する情報を取得する
   * @param locationPoint 地点の緯度・経度
   * @return {@link WeatherApiResponse}
   */
  WeatherApiResponse fetch(final LocationPoint locationPoint);
}

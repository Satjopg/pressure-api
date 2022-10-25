package jp.satjopg.api.infrastructure.client.weather;

import jp.satjopg.api.value.LocationPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

// WeatherMap APIを利用するためのクラス
// 実装を公開する必要はない
@Component
@lombok.RequiredArgsConstructor
class WeatherApiClientImpl implements WeatherApiClient {

  private final WeatherMapApiSetting weatherMapApiSetting;
  private final WebClient weatherMapApiWebClient;

  /**
   * {@inheritDoc}
   */
  @Override
  public WeatherApiResponse fetch(final LocationPoint locationPoint) {
    return weatherMapApiWebClient
        .get()
        .uri(uriBuilder -> uriBuilder
            .path(weatherMapApiSetting.version() + weatherMapApiSetting.currentWeatherPath())
            .queryParam("lat", locationPoint.latitude())
            .queryParam("lon", locationPoint.longitude())
            .queryParam("appid", weatherMapApiSetting.appID())
            .build()
        )
        .retrieve()
        .bodyToMono(WeatherApiResponse.class)
        .log()
        .block();
  }
}

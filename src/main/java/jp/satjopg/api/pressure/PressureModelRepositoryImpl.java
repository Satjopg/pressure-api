package jp.satjopg.api.pressure;

import jp.satjopg.api.infrastructure.client.weather.WeatherApiClient;
import jp.satjopg.api.infrastructure.client.weather.WeatherApiResponse;
import jp.satjopg.api.value.LocationPoint;
import org.springframework.stereotype.Repository;

@Repository
@lombok.RequiredArgsConstructor
class PressureModelRepositoryImpl implements PressureModelRepository {

  private final WeatherApiClient weatherApiClient;

  /**
   * {@inheritDoc}
   */
  @Override
  public PressureModel fetch(final LocationPoint locationPoint) {
    final WeatherApiResponse response = weatherApiClient.fetch(locationPoint);
    return PressureModel.of(response, locationPoint);
  }
}

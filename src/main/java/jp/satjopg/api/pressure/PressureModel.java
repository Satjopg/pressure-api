package jp.satjopg.api.pressure;

import jp.satjopg.api.infrastructure.client.weather.WeatherApiResponse;
import jp.satjopg.api.pressure.dto.PressureApiResponse;
import jp.satjopg.api.value.LocationName;
import jp.satjopg.api.value.LocationPoint;


@lombok.Builder(access = lombok.AccessLevel.PRIVATE)
record PressureModel(
    LocationPoint locationPoint,
    LocationName locationName,
    Pressure pressure
) {

  public static PressureModel of(final WeatherApiResponse response,
      final LocationPoint locationPoint) {
    return PressureModel.builder()
        .locationName(LocationName.from(response.name()))
        .pressure(Pressure.from(response.main().pressure()))
        .locationPoint(locationPoint)
        .build();
  }

  public PressureApiResponse toResponse() {
    return new PressureApiResponse(
        this.locationName.toString(),
        this.pressure.toInteger(),
        this.locationPoint.latitude(),
        this.locationPoint.longitude()
    );
  }
}

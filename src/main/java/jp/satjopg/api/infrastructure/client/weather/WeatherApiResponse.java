package jp.satjopg.api.infrastructure.client.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

// WeatherMapAPIのレスポンスクラス
// RecordでJsonNamingが動かず泣く泣くJsonPropertyに変更...
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record WeatherApiResponse(
    Main main,
    String name
) {

  @JsonIgnoreProperties(ignoreUnknown = true)
//  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public record Main(
      Double temp,
      @JsonProperty("feels_like")
      Double feelsLike,
      Integer pressure,
      Integer humidity
  ) {
  }

}

package jp.satjopg.api.infrastructure.client.zutool;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
class ZutoolApiResponse implements Serializable {

  @Serial
  private static final long serialVersionUID = -1505454645122572886L;

  private String placeName;
  private String placeId;
  private String prefecturesId;
  @JsonProperty("dateTime")
  private String dateTime;
  private List<WeatherFields> today;
  private List<WeatherFields> tomorrow;

  @lombok.Data
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
  public static class WeatherFields implements Serializable {

    @Serial
    private static final long serialVersionUID = -871644693895857393L;

    private Integer time;
    private Integer weather;
    private Double temp;
    private Double pressure;
    private Integer pressureLevel;
  }
}

package jp.satjopg.api.infrastructure.client.weather;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("internal.config.api.weather")
record WeatherMapApiSetting(
    String baseURL,
    String version,
    String currentWeatherPath,
    String appID
) {}

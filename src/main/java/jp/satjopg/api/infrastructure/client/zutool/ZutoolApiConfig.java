package jp.satjopg.api.infrastructure.client.zutool;

import io.netty.channel.ChannelOption;
import java.time.Duration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

@Configuration
class ZutoolApiConfig {
  @Bean
  public WebClient zutoolApiWebClient (final ZutoolApiSetting setting) {
    final ReactorClientHttpConnector reactorClientHttpConnector = new ReactorClientHttpConnector(
        HttpClient.create()
            .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 1000)
            .responseTimeout(Duration.ofMillis(3000))
    );
    return WebClient.builder()
        .clientConnector(reactorClientHttpConnector)
        .baseUrl(setting.baseURL())
        .build();
  }
}

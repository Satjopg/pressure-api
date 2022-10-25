package jp.satjopg.api.infrastructure.client.zutool;

import jp.satjopg.api.infrastructure.client.zutool.interfaces.ZutoolClient;
import jp.satjopg.api.infrastructure.client.zutool.interfaces.ZutoolModel;
import jp.satjopg.api.infrastructure.client.zutool.interfaces.ZutoolModelFactory;
import jp.satjopg.api.value.LocationId;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
@lombok.extern.slf4j.Slf4j
@lombok.RequiredArgsConstructor
class ZutoolClientImpl implements ZutoolClient {

  private static final String PREFIX_PATH = "/api/getweatherstatus/%s";

  private final WebClient zutoolApiWebClient;
  private final ZutoolModelFactory<ZutoolApiResponse> factory;
  /**
   * {@inheritDoc}
   */
  @Override
  public ZutoolModel fetch(final LocationId id) {
    final ZutoolApiResponse response = zutoolApiWebClient
        .get()
        .uri(uriBuilder ->
            uriBuilder
                .path(PREFIX_PATH.formatted(id.toString()))
                .build()
        )
        .retrieve()
        .bodyToMono(ZutoolApiResponse.class)
        .log()
        .block();
    return factory.create(response);
  }
}

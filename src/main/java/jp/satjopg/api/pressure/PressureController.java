package jp.satjopg.api.pressure;

import jp.satjopg.api.pressure.dto.PressureApiRequest;
import jp.satjopg.api.pressure.dto.PressureApiResponse;
import jp.satjopg.api.value.LocationPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@lombok.RequiredArgsConstructor
class PressureController {

  private final PressureModelRepository pressureModelRepository;

  /**
   * 現在時刻の気圧を取得する
   * @param request リクエストパラメータ
   * @return {@link PressureApiResponse}
   */
  @GetMapping(path = "/pressure")
  public PressureApiResponse get(final PressureApiRequest request) {
    return pressureModelRepository
        .fetch(LocationPoint.of(request.lon(), request.lat()))
        .toResponse();
  }
}

package jp.satjopg.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
class ErrorResponseFactory {

  /**
   * エラーレスポンスクラスを作成する
   * @param status ステータスコード
   * @param exception 例外クラス
   * @return {@link ErrorResponse} エラーレスポンス
   */
  public ErrorResponse create(final HttpStatus status, final Exception exception) {
    return new ErrorResponse(status.value(), exception.getMessage());
  }
}

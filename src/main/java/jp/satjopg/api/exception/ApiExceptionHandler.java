package jp.satjopg.api.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@lombok.RequiredArgsConstructor
class ApiExceptionHandler {

  private final ErrorResponseFactory errorResponseFactory;

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler({ IllegalArgumentException.class })
  public ErrorResponse handleIllegalArgument (final IllegalArgumentException exception) {
    log.error("バリデーションエラーが発生しました: {}", exception.getMessage());
    return errorResponseFactory.create(HttpStatus.BAD_REQUEST, exception);
  }

  @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({ RuntimeException.class })
  public ErrorResponse handleUnknownException (final RuntimeException exception) {
    log.error("処理中に予期せぬエラーが発生しました 例外名: {} メッセージ: {}", exception.getClass().getSimpleName(), exception.getMessage());
    return errorResponseFactory.create(HttpStatus.INTERNAL_SERVER_ERROR, exception);
  }
}

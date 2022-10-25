package jp.satjopg.api.exception;

import java.io.Serializable;

record ErrorResponse (
    Integer code,
    String message
) implements Serializable {}

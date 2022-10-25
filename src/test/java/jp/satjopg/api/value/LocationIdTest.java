package jp.satjopg.api.value;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LocationIdTest {

  @ParameterizedTest
  @ValueSource(strings = {"01000","10000","20000","30000","47999"})
  void 指定されたIDを正しく判定しLocationIdクラスのオブジェクトを生成することができる(
      String correctId
  ) {
    final var actual = LocationId.from(correctId);
    assertEquals(actual.toString(), correctId);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "0", "00", "000", "0000", "00000", "50000", "000000"})
  void 不正なIDの値が指定されたときに例外を上げることができる(
      String incorrectId
  ) {
    assertThrows(IllegalArgumentException.class, () -> LocationId.from(incorrectId));
  }
}

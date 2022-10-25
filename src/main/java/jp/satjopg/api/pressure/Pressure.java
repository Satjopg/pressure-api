package jp.satjopg.api.pressure;

import java.util.Objects;
import org.springframework.lang.NonNull;

// 気圧の値
@lombok.RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
class Pressure {

  // @note 気圧の値に制限はないが900から1100くらいの間で観測されているため突拍子もない数字は異常値として扱うために制限を設けている
  private static final Integer MAX_VALUE = 1500;
  private static final Integer MIN_VALUE = 800;

  @NonNull
  private final Integer value;

  /**
   * 気圧の値オブジェクトを作成する
   * @param value 気圧の値
   * @return 気圧の値オブジェクト
   */
  public static Pressure from (final Integer value) {
    if (Objects.isNull(value)) {
      throw new IllegalArgumentException("気圧の値が指定されていません");
    }
    if (value < MIN_VALUE || value > MAX_VALUE) {
      throw new IllegalArgumentException("気圧の値は%dから%dの値を選択してください".formatted(MIN_VALUE, MAX_VALUE));
    }
    return new Pressure(value);
  }

  /**
   * 気圧の値オブジェクトを数値に変換する
   * @return 気圧の値の数値
   */
  public Integer toInteger() {
    return this.value;
  }
}

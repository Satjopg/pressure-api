package jp.satjopg.api.value;

import lombok.AccessLevel;

// 地点名
@lombok.RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class LocationName {
  private final String name;

  /**
   * 地点名を作成する
   * @param name 地点名
   * @return 地点名オブジェクト
   */
  public static LocationName from(final String name) {
    if (name.isEmpty()) {
      throw new IllegalArgumentException("地点名が空文字であったため生成できませんでした");
    }
    return new LocationName(name);
  }

  /**
   * 地点名オブジェクトを文字列に変換する
   * @return 地点名の文字列
   */
  public String toString() {
    return this.name;
  }
}

package jp.satjopg.api.value;

@lombok.Builder(access = lombok.AccessLevel.PRIVATE)
@lombok.RequiredArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class LocationId {

  private static final String ID_PATTERN = "(0[1-9]|[1-3]\\d|4[0-7])\\d{3}";
  private final String id;

  public static LocationId from (final String id) {
    if (id.isEmpty()) {
      throw new IllegalArgumentException("文字列が指定されていません");
    }
    if (!id.matches(ID_PATTERN)) {
      throw new IllegalArgumentException("指定文字列: %s はパターンに合致していません".formatted(id));
    }
    return LocationId.builder().id(id).build();
  }

  public String toString() {
    return this.id;
  }
}

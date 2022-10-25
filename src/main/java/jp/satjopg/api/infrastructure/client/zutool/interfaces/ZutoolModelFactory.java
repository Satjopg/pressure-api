package jp.satjopg.api.infrastructure.client.zutool.interfaces;

public interface ZutoolModelFactory<T> {

  /**
   * ZutoolModelクラスのオブジェクトを作成する
   * @param source ZutoolModel作成元情報
   * @return {@link ZutoolModel}
   */
  ZutoolModel create(final T source);
}

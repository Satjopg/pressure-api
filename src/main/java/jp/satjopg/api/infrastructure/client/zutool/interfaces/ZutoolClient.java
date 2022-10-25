package jp.satjopg.api.infrastructure.client.zutool.interfaces;

import jp.satjopg.api.value.LocationId;

public interface ZutoolClient {

  ZutoolModel fetch (final LocationId id);
}

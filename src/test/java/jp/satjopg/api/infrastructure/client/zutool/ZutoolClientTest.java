package jp.satjopg.api.infrastructure.client.zutool;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import jp.satjopg.api.infrastructure.client.zutool.interfaces.ZutoolClient;
import jp.satjopg.api.value.LocationId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZutoolClientTest {
  @Autowired
  ZutoolClient zutoolClient;

  @Test
  void test() {
    final var actual = zutoolClient.fetch(LocationId.from("14215"));
    assertNotNull(actual);
  }
}

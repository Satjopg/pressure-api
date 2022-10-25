package jp.satjopg.api.infrastructure.client.zutool;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("internal.config.api.zutool")
record ZutoolApiSetting(
    String baseURL
) {}
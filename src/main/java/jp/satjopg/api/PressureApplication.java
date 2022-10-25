package jp.satjopg.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PressureApplication {

	public static void main(String[] args) {
		SpringApplication.run(PressureApplication.class, args);
	}

}

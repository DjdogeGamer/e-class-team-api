package eclass.hackthon.mercedesbenz.io.eclassteam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class that creates a RestTemplate bean.
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
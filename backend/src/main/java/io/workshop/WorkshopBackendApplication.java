package io.workshop;

import io.workshop.openai.OpenAiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(OpenAiProperties.class)
public class WorkshopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkshopBackendApplication.class, args);
	}

}

package io.workshop.openai;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@ConfigurationProperties(prefix = "openai")
public class OpenAiProperties {
    // see https://platform.openai.com/docs/api-reference/authentication for details
    @NotBlank private String apiKey;
    @NotBlank private String model;
    private Float temperature;
    @NotBlank private String completionsEndpoint;
}

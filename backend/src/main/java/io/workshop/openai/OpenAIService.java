package io.workshop.openai;

import io.workshop.model.WorkshopActivity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OpenAIService {

    private static final String PROMPT_TEMPLATE = "Generate a list of %s engaging and interactive activities for a workshop focused on %s.";
    private static final String AUTH_HEADER_TEMPLATE = "Bearer %s";

    private final OpenAiProperties openAiProperties;
    private final RestTemplate restTemplate;

    public List<WorkshopActivity> generateActivitiesForTopic(final String topic, final int numberOfActivities) {

        final var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", AUTH_HEADER_TEMPLATE.formatted(openAiProperties.getApiKey()));

        final var body = new HashMap<String, Object>();
        body.put("model", openAiProperties.getModel());
        body.put("temperature", openAiProperties.getTemperature());
        body.put("messages", List.of(
                new HashMap() {{
                    put("role", "user");
                    put("content", PROMPT_TEMPLATE.formatted(numberOfActivities, topic));
                }}
        ));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<OpenAIResponse> response = restTemplate.postForEntity(
                    openAiProperties.getCompletionsEndpoint(),
                    entity,
                    OpenAIResponse.class);
            return response.getBody().getChoices().stream()
                    .map(OpenAIResponse.Choice::getMessage)
                    .map(OpenAIResponse.ChoiceMessage::getContent)
                    .map(text -> text.split("\n\n"))
                    .flatMap(Arrays::stream)
                    .map(s -> s.replaceAll("^\\d+\\.\\s+", "").trim())
                    .map(s -> {
                        // each suggestion looks like sometext: othertext format
                        // so we need to split it by ': '
                        final var sections = s.split(": ");
                        final var name = sections[0];
                        final var description = sections[1];
                        return WorkshopActivity.builder()
                                .name(name)
                                .description(description)
                                .build();
                    })
                    .collect(Collectors.toList());
        } catch (HttpClientErrorException.TooManyRequests clientError) {
            System.out.println("Quota expired!" + clientError.getMessage());
            return List.of();
        } catch (Exception ex) {
            System.out.println("Unknown error: " + ex.getMessage());
            return List.of();
        }
    }
}

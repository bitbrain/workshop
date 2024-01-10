package io.workshop.web;

import io.workshop.model.Participant;
import io.workshop.model.Workshop;
import io.workshop.model.WorkshopActivity;
import io.workshop.model.id.ParticipantId;
import io.workshop.openai.OpenAIService;
import io.workshop.repository.ParticipantRepository;
import io.workshop.repository.WorkshopActivityRepository;
import io.workshop.repository.WorkshopRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@AllArgsConstructor
@RestController
@RequestMapping("/workshops")
public class WorkshopController {

    private final WorkshopRepository workshopRepository;
    private final ParticipantRepository participantRepository;
    private final OpenAIService openAIService;
    private final WorkshopActivityRepository workshopActivityRepository;

    @GetMapping
    public ResponseEntity<List<Workshop>> listWorkshops() {
        return ResponseEntity.ok(workshopRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Workshop> getWorkshop(@PathVariable("id") final Integer workshopId) {
        return workshopRepository.findById(workshopId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/participants")
    public ResponseEntity<List<Participant>> getParticipants(@PathVariable("id") final Integer workshopId) {
        return ResponseEntity.ok(participantRepository.findByWorkshopId(workshopId));
    }

    @GetMapping("/generate-activities/{topic}")
    public List<WorkshopActivity> generateActivitiesForTopic(@PathVariable("topic") final String topic) {
        return openAIService.generateActivitiesForTopic(topic, 3);
    }

    @GetMapping("/{id}/generate-activities")
    public ResponseEntity<List<WorkshopActivity>> generateActivities(@PathVariable("id") final Integer workshopId) {
        final var workshop = workshopRepository.findById(workshopId);
        if (workshop.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        final var activities = openAIService.generateActivitiesForTopic(workshop.get().getName(), 3)
                .stream()
                .peek(activity -> activity.setWorkshop(workshop.get()))
                .toList();
        final var savedActivities = workshopActivityRepository.saveAll(activities);
        return ResponseEntity.ok(savedActivities);
    }

}

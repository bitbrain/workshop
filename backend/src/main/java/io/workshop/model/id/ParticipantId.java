package io.workshop.model.id;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Embeddable
public class ParticipantId implements Serializable {
    private Integer workshopId;
    private Integer userId;
}

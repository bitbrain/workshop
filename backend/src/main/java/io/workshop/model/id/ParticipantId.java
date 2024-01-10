package io.workshop.model.id;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Data
@Embeddable
public class ParticipantId implements Serializable {
    private Integer workshopId;
    private Integer userId;
}

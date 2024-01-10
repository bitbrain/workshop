package io.workshop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.workshop.model.id.ParticipantId;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "participant")
public class Participant {

    @JsonIgnore
    @EmbeddedId
    private ParticipantId id;

    @ManyToOne
    @MapsId("workshopId")
    @JoinColumn(name = "workshop_id", insertable = false, updatable = false)
    private Workshop workshop;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    private User user;

    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
}

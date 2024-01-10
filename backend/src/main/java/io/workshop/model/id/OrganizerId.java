package io.workshop.model.id;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode
@Embeddable
public class OrganizerId implements Serializable {

    private Integer workshopId;
    private Integer userId;
}

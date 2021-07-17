package com.ghadif.persistence.schema.character.casting;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString
@EqualsAndHashCode
public abstract class Casting {

    @Id
    private String id;

    private final Integer points;
    private final Integer pointsUsed;
    private final Set<? extends Power> powers;

    public Casting(Integer points, Integer pointsUsed, Set<? extends Power> powers) {
        this.points = points;
        this.pointsUsed = pointsUsed;
        this.powers = powers;
    }
}
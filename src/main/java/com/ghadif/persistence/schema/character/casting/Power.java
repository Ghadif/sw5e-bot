package com.ghadif.persistence.schema.character.casting;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString
@EqualsAndHashCode
public abstract class Power {

    @Id
    private String id;

    private final String name;
    private final Integer level;
    private final Integer range;
    private final String castingPeriod;
    private final String duration;
    private final Boolean requiresConcentration;

    protected Power(String name, Integer level, Integer range,
                    String castingPeriod, String duration, Boolean requiresConcentration) {
        this.name = name;
        this.level = level;
        this.range = range;
        this.castingPeriod = castingPeriod;
        this.duration = duration;
        this.requiresConcentration = requiresConcentration;
    }
}

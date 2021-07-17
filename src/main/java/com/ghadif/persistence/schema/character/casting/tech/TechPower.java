package com.ghadif.persistence.schema.character.casting.tech;

import com.ghadif.persistence.schema.character.casting.Power;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TechPower extends Power {

    @PersistenceConstructor
    public TechPower(String name, Integer level, Integer range,
                     String castingPeriod, String duration, Boolean requiresConcentration) {
        super(name, level, range, castingPeriod, duration, requiresConcentration);
    }
}

package com.ghadif.persistence.schema.character.casting.force;

import com.ghadif.persistence.schema.character.casting.Power;
import com.ghadif.persistence.schema.character.enums.ForceAlignment;
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
public class ForcePower extends Power {
    private final ForceAlignment forceAlignment;

    @PersistenceConstructor
    public ForcePower(String name, Integer level, Integer range, String castingPeriod, String duration, Boolean requiresConcentration, ForceAlignment forceAlignment) {
        super(name, level, range, castingPeriod, duration, requiresConcentration);
        this.forceAlignment = forceAlignment;
    }
}

package com.ghadif.persistence.schema.character.casting.force;

import com.ghadif.persistence.schema.character.casting.Casting;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ForceCasting extends Casting {


    @PersistenceConstructor
    public ForceCasting(Integer points, Integer pointsUsed, Set<ForcePower> powers) {
        super(points, pointsUsed, powers);
    }
}

package com.ghadif.persistence.schema.character.casting.tech;

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
public class TechCasting extends Casting {


    @PersistenceConstructor
    public TechCasting(Integer points, Integer pointsUsed, Set<TechPower> powers) {
        super(points, pointsUsed, powers);
    }
}

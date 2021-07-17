package com.ghadif.persistence.schema.character.attributes.stats;

import com.ghadif.persistence.schema.character.attributes.SavingThrow;
import com.ghadif.persistence.schema.character.attributes.Skill;
import lombok.Builder;
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
public class Strength extends AbilityScore {
    private final Skill athletics;

    @Builder
    public Strength(Integer value, Boolean isSavingThrowProficient, Skill athletics) {
        super(value, isSavingThrowProficient);
        this.athletics = athletics;
    }

    @PersistenceConstructor
    Strength(Integer value, Integer modifier, SavingThrow savingThrow, Skill athletics) {
        super(value, modifier, savingThrow);
        this.athletics = athletics;
    }
}

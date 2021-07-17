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
public class Charisma extends AbilityScore {

    private final Skill deception;
    private final Skill intimidation;
    private final Skill performance;
    private final Skill persuasion;

    @Builder
    public Charisma(Integer value, Boolean isSavingThrowProficient, Skill deception, Skill intimidation, Skill performance, Skill persuasion) {
        super(value, isSavingThrowProficient);
        this.deception = deception;
        this.intimidation = intimidation;
        this.performance = performance;
        this.persuasion = persuasion;
    }

    @PersistenceConstructor
    Charisma(Integer value, Integer modifier, SavingThrow savingThrow,
                    Skill deception, Skill intimidation, Skill performance, Skill persuasion) {
        super(value, modifier, savingThrow);
        this.deception = deception;
        this.intimidation = intimidation;
        this.performance = performance;
        this.persuasion = persuasion;
    }
}

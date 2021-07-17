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
public class Dexterity extends AbilityScore {

    private final Skill acrobatics;
    private final Skill sleightOfHand;
    private final Skill stealth;

    @Builder
    public Dexterity(Integer value, Boolean isSavingThrowProficient, Skill acrobatics, Skill sleightOfHand, Skill stealth) {
        super(value, isSavingThrowProficient);
        this.acrobatics = acrobatics;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
    }

    @PersistenceConstructor
    Dexterity(Integer value, Integer modifier, SavingThrow savingThrow, Skill acrobatics, Skill sleightOfHand, Skill stealth) {
        super(value, modifier, savingThrow);
        this.acrobatics = acrobatics;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
    }
}

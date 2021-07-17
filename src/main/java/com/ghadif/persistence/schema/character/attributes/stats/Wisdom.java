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
public class Wisdom extends AbilityScore {

    private final Skill animalHandling;
    private final Skill insight;
    private final Skill medicine;
    private final Skill perception;
    private final Skill survival;

    @Builder
    public Wisdom(Integer value, Boolean isSavingThrowProficient,
                  Skill animalHandling, Skill insight, Skill medicine, Skill perception, Skill survival) {
        super(value, isSavingThrowProficient);
        this.animalHandling = animalHandling;
        this.insight = insight;
        this.medicine = medicine;
        this.perception = perception;
        this.survival = survival;
    }

    @PersistenceConstructor
    Wisdom(Integer value, Integer modifier, SavingThrow savingThrow,
           Skill animalHandling, Skill insight, Skill medicine, Skill perception, Skill survival) {
        super(value, modifier, savingThrow);
        this.animalHandling = animalHandling;
        this.insight = insight;
        this.medicine = medicine;
        this.perception = perception;
        this.survival = survival;
    }

}

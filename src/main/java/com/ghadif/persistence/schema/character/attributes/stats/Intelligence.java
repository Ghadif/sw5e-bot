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
public class Intelligence extends AbilityScore {

    private final Skill investigation;
    private final Skill lore;
    private final Skill nature;
    private final Skill piloting;
    private final Skill technology;

    @Builder
    public Intelligence(Integer value, Boolean isSavingThrowProficient,
                        Skill investigation, Skill lore, Skill nature, Skill piloting, Skill technology) {
        super(value, isSavingThrowProficient);
        this.investigation = investigation;
        this.lore = lore;
        this.nature = nature;
        this.piloting = piloting;
        this.technology = technology;
    }

    @PersistenceConstructor
    Intelligence(Integer value, Integer modifier, SavingThrow savingThrow,
                 Skill investigation, Skill lore, Skill nature, Skill piloting, Skill technology) {
        super(value, modifier, savingThrow);
        this.investigation = investigation;
        this.lore = lore;
        this.nature = nature;
        this.piloting = piloting;
        this.technology = technology;
    }
}

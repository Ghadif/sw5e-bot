package com.ghadif.persistence.schema.character.attributes.stats;

import com.ghadif.persistence.schema.character.attributes.SavingThrow;
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
public class Constitution extends AbilityScore {

    @Builder
    public Constitution(Integer value, Boolean isSavingThrowProficient) {
        super(value, isSavingThrowProficient);
    }

    @PersistenceConstructor
    Constitution(Integer value, Integer modifier, SavingThrow savingThrow) {
        super(value, modifier, savingThrow);
    }
}

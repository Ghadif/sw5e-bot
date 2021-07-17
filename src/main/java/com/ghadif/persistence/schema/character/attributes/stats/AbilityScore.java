package com.ghadif.persistence.schema.character.attributes.stats;

import com.ghadif.persistence.schema.character.attributes.SavingThrow;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString
@EqualsAndHashCode
public class AbilityScore {

    @Id
    private String id;

    private final Integer value;
    private final Integer modifier;
    private final SavingThrow savingThrow;

    AbilityScore(Integer value, Boolean isSavingThrowProficient) {
        this.value = value;
        this.modifier = value >= 10
                ? (value - 10) / 2
                : (value - 11) / 2;
        this.savingThrow = new SavingThrow(isSavingThrowProficient);
    }

    AbilityScore(Integer value, Integer modifier, SavingThrow savingThrow) {
        this.value = value;
        this.modifier = modifier;
        this.savingThrow = savingThrow;
    }
}

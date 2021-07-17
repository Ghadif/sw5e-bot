package com.ghadif.persistence.schema.character.health;

import com.ghadif.persistence.schema.character.enums.DieType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString
@EqualsAndHashCode
public class HitDice {
    @Id
    private String id;

    private final DieType dieType;
    private final Boolean spent;

    public HitDice(DieType dieType) {
        this.dieType = dieType;
        this.spent = false;
    }

    @PersistenceConstructor
    HitDice(DieType dieType, Boolean spent) {
        this.dieType = dieType;
        this.spent = spent;
    }
}

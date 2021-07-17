package com.ghadif.persistence.schema.character.skills;

import com.ghadif.persistence.schema.character.enums.MovementType;
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
public class CombatMovement {

    @Id
    private String id;

    private final MovementType movementType;
    private final Integer movement;

    @PersistenceConstructor
    public CombatMovement(MovementType movementType, Integer movement) {
        this.movementType = movementType;
        this.movement = movement;
    }
}

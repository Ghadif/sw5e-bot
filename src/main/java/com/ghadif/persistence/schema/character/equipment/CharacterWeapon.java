package com.ghadif.persistence.schema.character.equipment;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CharacterWeapon extends Equipment {

    public CharacterWeapon(String name, Integer weight) {
        super(name, weight);
    }
}

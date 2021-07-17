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
public class Weapon extends Equipment {

    public Weapon(String name, Integer weight) {
        super(name, weight);
    }
}

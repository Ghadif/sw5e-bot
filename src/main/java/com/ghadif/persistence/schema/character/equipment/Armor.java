package com.ghadif.persistence.schema.character.equipment;

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
public class Armor extends Equipment {

    @PersistenceConstructor
    public Armor(String name, Integer weight) {
        super(name, weight);
    }

}

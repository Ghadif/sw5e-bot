package com.ghadif.persistence.schema.character.health;

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
public class HitPoints {

    @Id
    private String id;

    private final Integer maximum;
    private final Integer current;
    private final Integer temporary;

    public HitPoints(Integer maximum) {
        this.maximum = maximum;
        this.current = maximum;
        this.temporary = 0;
    }

    @PersistenceConstructor
    HitPoints(Integer maximum, Integer current, Integer temporary) {
        this.maximum = maximum;
        this.current = current;
        this.temporary = temporary;
    }
}

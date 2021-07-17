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
public class DeathSaves {

    @Id
    private String id;

    private final Integer successes;
    private final Integer fails;

    public DeathSaves() {
        this.successes = 0;
        this.fails = 0;
    }

    @PersistenceConstructor
    DeathSaves(Integer successes, Integer fails) {
        this.successes = successes;
        this.fails = fails;
    }
}

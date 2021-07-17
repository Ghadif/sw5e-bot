package com.ghadif.persistence.schema.character.attributes;

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
public final class Skill {
    @Id
    private String id;

    private final Boolean isProficient;
    private final Boolean isExpert;

    @PersistenceConstructor
    public Skill(Boolean isProficient, Boolean isExpert) {
        this.isProficient = isProficient;
        this.isExpert = isExpert;
    }
}

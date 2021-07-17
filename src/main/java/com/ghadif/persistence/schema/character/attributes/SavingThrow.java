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
public class SavingThrow {

    @Id
    private String id;

    private final Boolean isSavingThrowProficient;

    @PersistenceConstructor
    public SavingThrow(Boolean isSavingThrowProficient) {
        this.isSavingThrowProficient = isSavingThrowProficient;
    }
}

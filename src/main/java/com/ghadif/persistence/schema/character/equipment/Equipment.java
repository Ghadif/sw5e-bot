package com.ghadif.persistence.schema.character.equipment;

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
public class Equipment {

    @Id
    private String id;

    private final String name;
    private final Integer weight;

    public Equipment(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }
}

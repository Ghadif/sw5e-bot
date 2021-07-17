package com.ghadif.persistence.schema.character.skills;

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
public class CharacterFeature {

    @Id
    private String id;

    private final String title;
    private final String description;
    private final Integer level;

    @PersistenceConstructor
    public CharacterFeature(String title, String description, Integer level) {
        this.title = title;
        this.description = description;
        this.level = level;
    }
}

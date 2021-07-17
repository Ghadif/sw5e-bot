package com.ghadif.persistence.schema.character.attributes;

import com.ghadif.persistence.schema.character.attributes.stats.Charisma;
import com.ghadif.persistence.schema.character.attributes.stats.Constitution;
import com.ghadif.persistence.schema.character.attributes.stats.Dexterity;
import com.ghadif.persistence.schema.character.attributes.stats.Intelligence;
import com.ghadif.persistence.schema.character.attributes.stats.Strength;
import com.ghadif.persistence.schema.character.attributes.stats.Wisdom;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Attributes {

    @Id
    private String id;

    private final Strength strength;
    private final Dexterity dexterity;
    private final Constitution constitution;
    private final Intelligence intelligence;
    private final Wisdom wisdom;
    private final Charisma charisma;

    @Builder
    @PersistenceConstructor
    Attributes(Strength strength, Dexterity dexterity, Constitution constitution,
                      Intelligence intelligence, Wisdom wisdom, Charisma charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }
}

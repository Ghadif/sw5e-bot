package com.ghadif.persistence.schema.character.details;

import com.ghadif.persistence.schema.character.skills.CharacterFeature;
import lombok.Builder;
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
public class BackgroundDetails {

    @Id
    private String id;

    private final String background;

    private final CharacterFeature feature;
    private final String personalityTrait;
    private final String ideal;
    private final String bond;
    private final String flaw;

    private final String backstory;

    @Builder
    @PersistenceConstructor
    BackgroundDetails(String background, CharacterFeature feature,
                      String personalityTrait, String ideal, String bond, String flaw,
                      String backstory) {
        this.background = background;
        this.feature = feature;
        this.personalityTrait = personalityTrait;
        this.ideal = ideal;
        this.bond = bond;
        this.flaw = flaw;
        this.backstory = backstory;
    }
}

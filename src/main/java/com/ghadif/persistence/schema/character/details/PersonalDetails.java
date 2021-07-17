package com.ghadif.persistence.schema.character.details;

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
public class PersonalDetails {

    @Id
    private String id;

    private final String placeOfBirth;
    private final Integer age;
    private final String gender;
    private final Integer height;
    private final Integer weight;
    private final String eyeColour;
    private final String skinColour;

    private final String appearance;

    @Builder
    @PersistenceConstructor
    PersonalDetails(String placeOfBirth, Integer age, String gender, Integer height, Integer weight,
                    String eyeColour, String skinColour, String appearance) {
        this.placeOfBirth = placeOfBirth;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.eyeColour = eyeColour;
        this.skinColour = skinColour;
        this.appearance = appearance;
    }
}

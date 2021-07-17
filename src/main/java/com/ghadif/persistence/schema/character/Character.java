package com.ghadif.persistence.schema.character;

import com.ghadif.persistence.schema.character.attributes.Attributes;
import com.ghadif.persistence.schema.character.casting.force.ForceCasting;
import com.ghadif.persistence.schema.character.casting.tech.TechCasting;
import com.ghadif.persistence.schema.character.details.BackgroundDetails;
import com.ghadif.persistence.schema.character.details.PersonalDetails;
import com.ghadif.persistence.schema.character.enums.AlignmentType;
import com.ghadif.persistence.schema.character.enums.VisionType;
import com.ghadif.persistence.schema.character.equipment.Equipment;
import com.ghadif.persistence.schema.character.equipment.EquippedGear;
import com.ghadif.persistence.schema.character.health.DeathSaves;
import com.ghadif.persistence.schema.character.health.HitDice;
import com.ghadif.persistence.schema.character.health.HitPoints;
import com.ghadif.persistence.schema.character.skills.CharacterFeature;
import com.ghadif.persistence.schema.character.skills.CombatMovement;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.List;
import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Character {

    @Id
    private String id;

    //Base character data
    private final String name;
    private final Integer level;
    private final String characterClass;
    private final AlignmentType alignment;
    private final String species;
    private final Integer experiencePoints;
    private final String playerName;

    //Character attributes
    private final Attributes attributes;

    //Character HP stats
    private final HitPoints hitPoints;
    private final Set<HitDice> hitDice;
    private final DeathSaves deathSaves;

    //Character meta stats
    private final Integer initiative;
    private final Integer inspiration;
    private final Integer proficiencyBonus;
    private final Integer passivePerception;

    //Character vision and movements
    private final VisionType vision;
    private final Set<CombatMovement> combatMovements;

    //Character equipment
    private final Integer credits;
    private final List<Equipment> equipment;
    private final EquippedGear equippedGear;

    //Character features, languages and proficiencies
    private final Set<CharacterFeature> features;
    private final Set<String> languages;
    private final List<String> proficiencies;

    //Character details
    private final PersonalDetails personalDetails;
    private final BackgroundDetails backgroundDetails;

    //Character spells
    private final ForceCasting forceCasting;
    private final TechCasting techCasting;


    @Builder
    @PersistenceConstructor
    public Character(String name, Integer level, String characterClass, AlignmentType alignment,
                     String species, Integer experiencePoints, String playerName, Attributes attributes,
                     HitPoints hitPoints, Set<HitDice> hitDice, DeathSaves deathSaves,
                     Integer initiative, Integer inspiration, Integer proficiencyBonus, Integer passivePerception,
                     VisionType vision, Set<CombatMovement> combatMovements,
                     Integer credits, List<Equipment> equipment, EquippedGear equippedGear,
                     Set<CharacterFeature> features, Set<String> languages, List<String> proficiencies,
                     PersonalDetails personalDetails, BackgroundDetails backgroundDetails,
                     ForceCasting forceCasting, TechCasting techCasting) {
        this.name = name;
        this.level = level;
        this.characterClass = characterClass;
        this.alignment = alignment;
        this.species = species;
        this.experiencePoints = experiencePoints;
        this.playerName = playerName;
        this.attributes = attributes;
        this.hitPoints = hitPoints;
        this.hitDice = hitDice;
        this.deathSaves = deathSaves;
        this.initiative = initiative;
        this.inspiration = inspiration;
        this.proficiencyBonus = proficiencyBonus;
        this.passivePerception = passivePerception;
        this.vision = vision;
        this.combatMovements = combatMovements;
        this.credits = credits;
        this.equipment = equipment;
        this.equippedGear = equippedGear;
        this.features = features;
        this.languages = languages;
        this.proficiencies = proficiencies;
        this.personalDetails = personalDetails;
        this.backgroundDetails = backgroundDetails;
        this.forceCasting = forceCasting;
        this.techCasting = techCasting;
    }
}

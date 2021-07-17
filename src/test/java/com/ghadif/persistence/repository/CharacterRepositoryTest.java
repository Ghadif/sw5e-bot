package com.ghadif.persistence.repository;

import com.ghadif.persistence.schema.character.Character;
import com.ghadif.persistence.schema.character.attributes.Attributes;
import com.ghadif.persistence.schema.character.attributes.Skill;
import com.ghadif.persistence.schema.character.attributes.stats.Charisma;
import com.ghadif.persistence.schema.character.attributes.stats.Constitution;
import com.ghadif.persistence.schema.character.attributes.stats.Dexterity;
import com.ghadif.persistence.schema.character.attributes.stats.Intelligence;
import com.ghadif.persistence.schema.character.attributes.stats.Strength;
import com.ghadif.persistence.schema.character.attributes.stats.Wisdom;
import com.ghadif.persistence.schema.character.casting.force.ForceCasting;
import com.ghadif.persistence.schema.character.casting.force.ForcePower;
import com.ghadif.persistence.schema.character.casting.tech.TechCasting;
import com.ghadif.persistence.schema.character.casting.tech.TechPower;
import com.ghadif.persistence.schema.character.details.BackgroundDetails;
import com.ghadif.persistence.schema.character.details.PersonalDetails;
import com.ghadif.persistence.schema.character.enums.AlignmentType;
import com.ghadif.persistence.schema.character.enums.DieType;
import com.ghadif.persistence.schema.character.enums.ForceAlignment;
import com.ghadif.persistence.schema.character.enums.MovementType;
import com.ghadif.persistence.schema.character.enums.VisionType;
import com.ghadif.persistence.schema.character.equipment.Armor;
import com.ghadif.persistence.schema.character.equipment.CharacterWeapon;
import com.ghadif.persistence.schema.character.equipment.Equipment;
import com.ghadif.persistence.schema.character.equipment.EquippedGear;
import com.ghadif.persistence.schema.character.equipment.Shield;
import com.ghadif.persistence.schema.character.health.DeathSaves;
import com.ghadif.persistence.schema.character.health.HitDice;
import com.ghadif.persistence.schema.character.health.HitPoints;
import com.ghadif.persistence.schema.character.skills.CharacterFeature;
import com.ghadif.persistence.schema.character.skills.CombatMovement;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class CharacterRepositoryTest extends AbstractRepositoryTest {

    @Test
    void saveCharacter_returnsCharacter() {
        CharacterWeapon blaster = new CharacterWeapon("blaster", 5);
        Armor lightArmor = new Armor("light", 10);
        Shield energyShield = new Shield("energy", 1);

        Character savedCharacter = characterRepository.save(Character.builder()
                .name("Cras")
                .level(1)
                .characterClass("consular")
                .alignment(AlignmentType.CHAOTIC_GOOD)
                .species("togruta")
                .experiencePoints(0)
                .playerName("Ghadi")

                .attributes(Attributes.builder()
                        .strength(Strength.builder()
                                .value(16)
                                .isSavingThrowProficient(true)
                                .athletics(new Skill(true, false))
                                .build())
                        .dexterity(Dexterity.builder()
                                .value(14)
                                .isSavingThrowProficient(false)
                                .acrobatics(new Skill(true, false))
                                .sleightOfHand(new Skill(true, false))
                                .stealth(new Skill(true, false))
                                .build())
                        .constitution(Constitution.builder()
                                .value(15)
                                .isSavingThrowProficient(true)
                                .build())
                        .intelligence(Intelligence.builder()
                                .value(10)
                                .isSavingThrowProficient(false)
                                .investigation(new Skill(true, false))
                                .lore(new Skill(true, false))
                                .nature(new Skill(true, false))
                                .piloting(new Skill(true, false))
                                .technology(new Skill(true, false))
                                .build())
                        .wisdom(Wisdom.builder()
                                .value(13)
                                .isSavingThrowProficient(true)
                                .animalHandling(new Skill(true, false))
                                .insight(new Skill(true, false))
                                .medicine(new Skill(true, false))
                                .perception(new Skill(true, false))
                                .survival(new Skill(true, false))
                                .build())
                        .charisma(Charisma.builder()
                                .value(14)
                                .isSavingThrowProficient(false)
                                .deception(new Skill(true, false))
                                .intimidation(new Skill(true, false))
                                .performance(new Skill(true, false))
                                .persuasion(new Skill(true, false))
                                .build())
                        .build())

                .hitPoints(new HitPoints(8))
                .hitDice(Set.of(new HitDice(DieType.D8)))
                .deathSaves(new DeathSaves())

                .initiative(4)
                .inspiration(0)
                .proficiencyBonus(2)
                .passivePerception(2)

                .vision(VisionType.DARKVISION)
                .combatMovements(Set.of(new CombatMovement(MovementType.WALK, 30)))

                .credits(100)
                .equipment(List.of(blaster, lightArmor, energyShield, new Equipment("rope", 0)))
                .equippedGear(EquippedGear.builder()
                        .mainWeapon(blaster)
                        .shieldHeld(energyShield)
                        .armorWorn(lightArmor)
                        .build())

                .features(Set.of(new CharacterFeature("title", "description", 1)))
                .languages(Set.of("common"))
                .proficiencies(List.of("LIGHT_ARMOR"))

                .personalDetails(PersonalDetails.builder()
                        .placeOfBirth("placeOfBirth")
                        .age(42)
                        .gender("gender")
                        .height(20)
                        .weight(200)
                        .eyeColour("eyeColour")
                        .skinColour("skinColour")
                        .appearance("appearance")
                        .build())
                .backgroundDetails(BackgroundDetails.builder()
                        .background("background")
                        .feature(new CharacterFeature("title", "description", 10))
                        .personalityTrait("personalityTrait")
                        .ideal("ideal")
                        .bond("bond")
                        .flaw("flaw")
                        .backstory("backstory")
                        .build())

                .forceCasting(new ForceCasting(4, 4, Set.of(
                        new ForcePower("lightsaber throw", 1, 10, "1 action", "duration", false, ForceAlignment.UNIVERSAL)
                )))
                .techCasting(new TechCasting(4, 4, Set.of(
                        new TechPower("hack", 1, 10, "1 action", "duration", false)
                )))

                .build());

        assertEquals(savedCharacter, characterRepository.findAll().get(0));
        assertEquals(1, characterRepository.count());
    }
}

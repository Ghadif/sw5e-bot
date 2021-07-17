package com.ghadif.persistence.repository;

import com.ghadif.persistence.schema.character.enums.DieType;
import com.ghadif.persistence.schema.rulebook.weapon.DamageType;
import com.ghadif.persistence.schema.rulebook.weapon.MeleeWeapon;
import com.ghadif.persistence.schema.rulebook.weapon.RangedWeapon;
import com.ghadif.persistence.schema.rulebook.weapon.WeaponCategory;
import com.ghadif.persistence.schema.rulebook.weapon.property.WeaponProperty;
import com.ghadif.persistence.schema.rulebook.weapon.property.WeaponPropertyType;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class WeaponRepositoryTest extends AbstractRepositoryTest {

    @Test
    void saveRangedWeapon_returnsRangedWeapon() {
        RangedWeapon savedWeapon = weaponRepository.save(RangedWeapon.builder()
                .name("Blaster carbine")
                .damageDiceAmount(1)
                .damageDice(DieType.D6)
                .cost(300)
                .weight(8)
                .weaponCategory(WeaponCategory.SIMPLE_BLASTER)
                .damageType(DamageType.ENERGY)
                .weaponProperties(Set.of(
                        new WeaponProperty(WeaponPropertyType.AMMUNITION),
                        new WeaponProperty(WeaponPropertyType.RANGE),
                        new WeaponProperty(WeaponPropertyType.RELOAD, "16"),
                        new WeaponProperty(WeaponPropertyType.TWO_HANDED)
                ))
                .ammunition(16)
                .range(60)
                .maxRange(240)
                .build());

        assertEquals(savedWeapon, weaponRepository.findAll().get(0));
        assertEquals(1, weaponRepository.count());
    }

    @Test
    void saveMeleeWeapon_returnsRangedWeapon() {
        MeleeWeapon savedWeapon = weaponRepository.save(MeleeWeapon.builder()
                .name("Lightclub")
                .damageDiceAmount(1)
                .damageDice(DieType.D10)
                .cost(150)
                .weight(5)
                .weaponCategory(WeaponCategory.SIMPLE_LIGHTWEAPON)
                .damageType(DamageType.ENERGY)
                .weaponProperties(Set.of(
                        new WeaponProperty(WeaponPropertyType.LUMINOUS),
                        new WeaponProperty(WeaponPropertyType.TWO_HANDED)
                ))
                .build());

        assertEquals(savedWeapon, weaponRepository.findAll().get(0));
        assertEquals(1, weaponRepository.count());
    }
}

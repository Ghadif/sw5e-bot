package com.ghadif.persistence.schema.rulebook.weapon;

import com.ghadif.persistence.schema.character.enums.DieType;
import com.ghadif.persistence.schema.rulebook.weapon.property.WeaponProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class MeleeWeapon extends Weapon {

    @Builder
    @PersistenceConstructor
    public MeleeWeapon(String name, DieType damageDice, Integer damageDiceAmount, Integer cost, Integer weight,
                       WeaponCategory weaponCategory, DamageType damageType, Set<WeaponProperty> weaponProperties) {
        super(name, damageDice, damageDiceAmount, cost, weight, weaponCategory, damageType, weaponProperties);

        if (!WeaponCategory.WeaponType.MELEE.equals(weaponCategory.getWeaponType()))
            throw new IllegalArgumentException("Cannot instantiate a ranged weapon as a melee weapon");
    }
}

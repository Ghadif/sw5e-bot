package com.ghadif.persistence.schema.rulebook.weapon;

import com.ghadif.persistence.schema.character.enums.DieType;
import com.ghadif.persistence.schema.rulebook.weapon.property.WeaponProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.PersistenceConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RangedWeapon extends Weapon {

    @NotNull
    @Positive
    private final Integer ammunition;
    @NotNull
    @Positive
    private final Integer range;
    @NotNull
    @Positive
    private final Integer maxRange;


    @Builder
    @PersistenceConstructor
    public RangedWeapon(String name, DieType damageDice, Integer damageDiceAmount, Integer cost, Integer weight,
                        WeaponCategory weaponCategory, DamageType damageType, Set<WeaponProperty> weaponProperties,
                        Integer ammunition, Integer range, Integer maxRange) {
        super(name, damageDice, damageDiceAmount, cost, weight, weaponCategory, damageType, weaponProperties);
        this.ammunition = ammunition;
        this.range = range;
        this.maxRange = maxRange;

        if (!WeaponCategory.WeaponType.RANGED.equals(weaponCategory.getWeaponType()))
            throw new IllegalArgumentException("Cannot instantiate a melee weapon as a ranged weapon");



    }
}

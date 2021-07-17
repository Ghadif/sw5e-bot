package com.ghadif.persistence.schema.rulebook.weapon;

import com.ghadif.persistence.schema.character.enums.DieType;
import com.ghadif.persistence.schema.rulebook.weapon.property.WeaponProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
@ToString
@EqualsAndHashCode
public abstract class Weapon {
    @Id
    private String id;

    private final String name;
    private final DieType damageDice;
    private final Integer damageDiceAmount;
    private final Integer cost;
    private final Integer weight;
    private final WeaponCategory weaponCategory;
    private final DamageType damageType;
    private final Set<WeaponProperty> weaponProperties;

    Weapon(String name, DieType damageDice, Integer damageDiceAmount, Integer cost, Integer weight,
                  WeaponCategory weaponCategory, DamageType damageType, Set<WeaponProperty> weaponProperties) {
        this.name = name;
        this.damageDice = damageDice;
        this.damageDiceAmount = damageDiceAmount;
        this.cost = cost;
        this.weight = weight;
        this.weaponCategory = weaponCategory;
        this.damageType = damageType;
        this.weaponProperties = weaponProperties;
    }
}

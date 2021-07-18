package com.ghadif.persistence.schema.rulebook.weapon;

import com.ghadif.persistence.schema.character.enums.DieType;
import com.ghadif.persistence.schema.rulebook.weapon.property.WeaponProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
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

    @NotEmpty
    private final String name;
    @NotNull
    private final DieType damageDice;
    @NotNull
    @Positive
    private final Integer damageDiceAmount;
    @NotNull
    @Positive
    private final Integer cost;
    @NotNull
    @Positive
    private final Integer weight;
    @NotNull
    private final WeaponCategory weaponCategory;
    @NotNull
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

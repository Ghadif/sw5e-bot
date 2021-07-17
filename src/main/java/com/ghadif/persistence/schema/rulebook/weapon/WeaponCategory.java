package com.ghadif.persistence.schema.rulebook.weapon;

import lombok.Getter;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Getter
public enum WeaponCategory {
    SIMPLE_BLASTER(WeaponType.RANGED), MARTIAL_BLASTER(WeaponType.RANGED),
    SIMPLE_LIGHTWEAPON(WeaponType.MELEE), MARTIAL_LIGHTWEAPON(WeaponType.MELEE),
    SIMPLE_VIBROWEAPON(WeaponType.MELEE), MARTIAL_VIBROWEAPON(WeaponType.MELEE);

    private final WeaponType weaponType;

    WeaponCategory(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    enum WeaponType {
        RANGED, MELEE
    }
}

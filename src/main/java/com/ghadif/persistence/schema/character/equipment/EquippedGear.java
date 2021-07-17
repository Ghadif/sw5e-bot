package com.ghadif.persistence.schema.character.equipment;

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
public class EquippedGear {

    @Id
    private String id;

    private final Armor armorWorn;
    private final Shield shieldHeld;
    private final Weapon mainWeapon;
    private final Weapon secondaryWeapon;

    @Builder
    @PersistenceConstructor
    public EquippedGear(Armor armorWorn, Shield shieldHeld, Weapon mainWeapon, Weapon secondaryWeapon) {
        this.armorWorn = armorWorn;
        this.shieldHeld = shieldHeld;
        this.mainWeapon = mainWeapon;
        this.secondaryWeapon = secondaryWeapon;
    }
}

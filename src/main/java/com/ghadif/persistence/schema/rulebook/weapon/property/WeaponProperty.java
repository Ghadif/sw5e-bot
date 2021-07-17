package com.ghadif.persistence.schema.rulebook.weapon.property;

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
public class WeaponProperty {

    @Id
    private String id;

    private final WeaponPropertyType property;
    private final String detail;

    public WeaponProperty(WeaponPropertyType property) {
        this.property = property;
        this.detail = null;
    }

    @PersistenceConstructor
    public WeaponProperty(WeaponPropertyType property, String detail) {
        this.property = property;
        this.detail = detail;
    }
}

package com.ghadif.persistence.repository;

import com.ghadif.persistence.schema.rulebook.weapon.Weapon;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public interface WeaponRepository extends MongoRepository<Weapon, String> {
}

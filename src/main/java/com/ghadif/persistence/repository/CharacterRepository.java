package com.ghadif.persistence.repository;

import com.ghadif.persistence.schema.character.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Repository
public interface CharacterRepository extends MongoRepository<Character, String> {
}

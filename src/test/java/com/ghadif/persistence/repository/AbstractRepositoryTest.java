package com.ghadif.persistence.repository;

import com.ghadif.CustomTestConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@DataMongoTest
@Import({CustomTestConfiguration.class})
public class AbstractRepositoryTest {

    @Autowired
    private CharacterRepository characterRepository;

    @AfterEach
    void tearDown() {
        characterRepository.deleteAll();
    }
}

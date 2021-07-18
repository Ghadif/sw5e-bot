package com.ghadif.persistence.repository;

import com.ghadif.CustomTestConfiguration;
import com.ghadif.persistence.MongoDbConfiguration;
import com.ghadif.persistence.schema.rulebook.weapon.RangedWeapon;
import com.ghadif.persistence.schema.rulebook.weapon.WeaponCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest
@Import({CustomTestConfiguration.class, MongoDbConfiguration.class})
public class MongodbValidationTest {

    @Autowired
    private WeaponRepository weaponRepository;

    @Test
    void saveWeapon_invalidWeapon_throws() {
        ConstraintViolationException constraintViolationException = assertThrows(ConstraintViolationException.class,
                () -> weaponRepository.save(RangedWeapon.builder()
                        .weaponCategory(WeaponCategory.SIMPLE_BLASTER).build()));

        Set<String> constraintViolationMessages = Arrays.stream(constraintViolationException.getMessage().split(", ")).collect(Collectors.toSet());

        Set<String> expectedConstraintViolationMessages = new HashSet<>() {{
            add("weight: must not be null");
            add("ammunition: must not be null");
            add("maxRange: must not be null");
            add("damageType: must not be null");
            add("range: must not be null");
            add("name: must not be empty");
            add("damageDiceAmount: must not be null");
            add("cost: must not be null");
            add("damageDice: must not be null");
        }};

        assertEquals(expectedConstraintViolationMessages, constraintViolationMessages);
    }
}

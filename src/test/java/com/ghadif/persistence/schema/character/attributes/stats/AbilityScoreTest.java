package com.ghadif.persistence.schema.character.attributes.stats;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@ExtendWith(MockitoExtension.class)
public class AbilityScoreTest {

    @ParameterizedTest
    @MethodSource("generateAllPossibleAbilityScoreValues")
    void newAbilityScore_returnsCorrectModifier(int value, int expectedModifier) {
        AbilityScore abilityScore = new AbilityScore(value, false);

        assertEquals(expectedModifier, abilityScore.getModifier());
    }

    private static Stream<Arguments> generateAllPossibleAbilityScoreValues() {
        return Stream.of(
                Arguments.of(1, -5),
                Arguments.of(2, -4), Arguments.of(3, -4),
                Arguments.of(4, -3), Arguments.of(5, -3),
                Arguments.of(6, -2), Arguments.of(7, -2),
                Arguments.of(8, -1), Arguments.of(9, -1),
                Arguments.of(10, 0), Arguments.of(11, 0),
                Arguments.of(12, 1), Arguments.of(13, 1),
                Arguments.of(14, 2), Arguments.of(15,2),
                Arguments.of(16, 3), Arguments.of(17, 3),
                Arguments.of(18, 4), Arguments.of(19, 4),
                Arguments.of(20, 5), Arguments.of(21, 5),
                Arguments.of(22, 6), Arguments.of(23, 6),
                Arguments.of(24, 7), Arguments.of(25, 7),
                Arguments.of(26, 8), Arguments.of(27, 8),
                Arguments.of(28, 9), Arguments.of(29, 9),
                Arguments.of(30, 10)
        );
    }
}

package com.ghadif.helper;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class DiceCheckTest {

    @ParameterizedTest(name = "{index} --> {3} <= {0}d{1}+({2}) <= {4}")
    @CsvSource({
            "1, 4, 5, 6, 9",
            "5, 6, -10, -5, 20",
            "20, 8, 20, 40, 180",
            "7, 10, 100, 107, 170",
            "51, 12, -12, 39, 600",
            "12, 20, 6, 18 ,246",
            "5, 100, -125, -120, 375"
    })
    void roll_resultsBetweenCorrectRanges(int dieTotal, int dieFaces, int modifier, int minimum, int maximum) {
        int roll = new DiceCheck(dieTotal, dieFaces, modifier).roll();
        assertTrue(roll >= minimum && roll <= maximum);
        assertEquals(minimum, dieTotal + modifier);
        assertEquals(maximum, dieTotal * dieFaces + modifier);
    }
}

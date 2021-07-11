package com.ghadif.helper;

import org.junit.jupiter.api.RepeatedTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class DiceTest {

    @RepeatedTest(1000)
    void roll_AD4_resultsBetween1And4() {
        int roll = new Dice(4).roll();
        assertTrue(roll >= 1 && roll <= 4);
    }

    @RepeatedTest(1000)
    void roll_AD6_resultsBetween1And6() {
        int roll = new Dice(6).roll();
        assertTrue(roll >= 1 && roll <= 6);
    }

    @RepeatedTest(1000)
    void roll_AD8_resultsBetween1And8() {
        int roll = new Dice(8).roll();
        assertTrue(roll >= 1 && roll <= 8);
    }

    @RepeatedTest(1000)
    void roll_AD10_resultsBetween1And10() {
        int roll = new Dice(10).roll();
        assertTrue(roll >= 1 && roll <= 10);
    }

    @RepeatedTest(1000)
    void roll_AD12_resultsBetween1And12() {
        int roll = new Dice(12).roll();
        assertTrue(roll >= 1 && roll <= 12);
    }

    @RepeatedTest(1000)
    void roll_AD20_resultsBetween1And20() {
        int roll = new Dice(20).roll();
        assertTrue(roll >= 1 && roll <= 20);
    }


    @RepeatedTest(1000)
    void roll_AD100_resultsBetween1And100() {
        int roll = new Dice(100).roll();
        assertTrue(roll >= 1 && roll <= 100);
    }

}

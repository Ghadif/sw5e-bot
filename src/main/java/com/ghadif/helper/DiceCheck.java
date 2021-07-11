package com.ghadif.helper;

import lombok.Value;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Value
public class DiceCheck {

    Set<Dice> dice;
    int modifier;

    public DiceCheck(Set<Dice> dice, int modifier) {
        this.dice = dice;
        this.modifier = modifier;
    }

    public DiceCheck(int numberOfDie, int dieFaces, int modifier) {
        dice = new HashSet<>();
        for (int i = 0; i < numberOfDie; i++) {
            dice.add(new Dice(dieFaces));
        }
        this.modifier = modifier;

    }

    public int roll() {
        int totalRoll = modifier;
        for (Dice die : dice) {
            totalRoll += die.roll();
        }
        return totalRoll;
    }

    public Set<Dice> getDice() {
        return new HashSet<>(dice);
    }
}

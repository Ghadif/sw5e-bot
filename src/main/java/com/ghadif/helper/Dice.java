package com.ghadif.helper;

import lombok.Value;

import java.util.Random;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Value
public class Dice {

    int faces;
    Random random;

    public Dice(int faces) {
        this.faces = faces;
        this.random = new Random();
    }

    int roll() {
        return random.nextInt(faces) + 1;
    }
}

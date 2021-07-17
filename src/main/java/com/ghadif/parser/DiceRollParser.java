package com.ghadif.parser;

import com.ghadif.configuration.PatternMatcherSupplier;
import com.ghadif.helper.DiceCheck;
import org.springframework.stereotype.Service;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Service
public class DiceRollParser extends CommandParser {

    public DiceRollParser(PatternMatcherSupplier patternMatcherSupplier) {
        super(patternMatcherSupplier);
    }

    @Override
    public String getPatternMatcher() {
        return patternMatcherSupplier.getRoll();
    }

    @Override
    public String parseCommand(String command) {
        String diceCommand = command.replace("/roll ", "");

        int total = this.calculateDiceRollFromString(diceCommand);

        return String.format("%s = %d", diceCommand, total);
    }

    int calculateDiceRollFromString(String diceCommand) {
        String[] diceAttributesArray = diceCommand.split("[d+\\-]");

        final int numberOfDie = diceAttributesArray[0].isBlank()
                ? 1
                : Integer.parseInt(diceAttributesArray[0]);

        final int dieFaces = Integer.parseInt(diceAttributesArray[1]);

        int diceModifier = 0;
        if (diceAttributesArray.length == 3) {
            diceModifier = Integer.parseInt(diceAttributesArray[2]);
            diceModifier = diceCommand.contains("+")
                    ? diceModifier
                    : -diceModifier;
        }

        return new DiceCheck(numberOfDie, dieFaces, diceModifier).roll();
    }
}

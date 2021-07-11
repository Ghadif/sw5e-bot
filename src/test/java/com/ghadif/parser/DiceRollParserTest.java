package com.ghadif.parser;

import com.ghadif.CustomTestConfiguration;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import({CustomTestConfiguration.class})
public class DiceRollParserTest {

    @Autowired
    private DiceRollParser diceRollParser;

    @ParameterizedTest
    @ValueSource(strings = {
            "/roll d4", "/roll d4+1", "/roll d4-1", "/roll d4+3529", "/roll d4-1352",
            "/roll 1d4", "/roll 1d4+1", "/roll 1d4-1", "/roll 1d4+3529", "/roll 1d4-1352",
            "/roll 25d4", "/roll 25d4+1", "/roll 25d4-1", "/roll 25d4+3529", "/roll 25d4-1352",

            "/roll d20", "/roll d20+1", "/roll d20-1", "/roll d20+3529", "/roll d20-1352",
            "/roll 1d20", "/roll 1d20+1", "/roll 1d20-1", "/roll 1d20+3529", "/roll 1d20-1352",
            "/roll 25d20", "/roll 25d20+1", "/roll 25d20-1", "/roll 25d20+3529", "/roll 25d20-1352",

            "/roll d1", "/roll d55", "/roll d100", "/roll d30000", "/roll 14902d10"
    })
    void getPatternMatcher_correctCommands_returnsTrue(String command) {
        assertTrue(command.matches(diceRollParser.getPatternMatcher()));
    }
    @ParameterizedTest
    @ValueSource(strings = {
            "/rolld4", "roll d4+1", "/r d4-1", "!roll d4", ".roll d4"
    })
    void getPatternMatcher_incorrectCommands_returnsFalse(String command) {
        assertFalse(command.matches(diceRollParser.getPatternMatcher()));
    }

    @RepeatedTest(100)
    void parseCommand_returnsCorrectOutput() {
        String resultNumber = diceRollParser.parseCommand("/roll 5d20-8");
        assertTrue(resultNumber.startsWith("Result of 5d20-8 is "));

        int result = Integer.parseInt(resultNumber.split(" ")[4]);
        assertTrue(result >= -3 && result <= 92);
    }
}

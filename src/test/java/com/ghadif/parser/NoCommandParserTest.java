package com.ghadif.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class NoCommandParserTest {

    private NoCommandParser noCommandParser;

    @BeforeEach
    void setUp() {
        noCommandParser = new NoCommandParser();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "/hello", "Hello", "/help", "r1d20+1", "roll dex", "/r1d20+1"})
    void parseCommand_noMatterTheInput_returnsEmptyString(String command) {
        assertEquals("", noCommandParser.parseCommand(command));
    }
}

package com.ghadif.parser;

import com.ghadif.CustomTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import({CustomTestConfiguration.class})
public class HelpCommandParserTest {

    @Autowired
    private HelpCommandParser helpCommandParser;

    @Test
    void parseCommand_returnsHelpText() {
        String actualParsedCommand = helpCommandParser.parseCommand("the input does not matter");

        String expectedParsedCommand = """
                Hello, I'm the unofficial SW5e bot.
                For now, only the help command is implemented.
                You can call it from /help""";
        assertEquals(expectedParsedCommand, actualParsedCommand);
    }
}

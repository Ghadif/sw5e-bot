package com.ghadif.parser;

import com.ghadif.CustomTestConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import({CustomTestConfiguration.class})
public class CommandParserDecoratorTest {

    @Autowired
    private CommandParserDecorator commandParserDecorator;

    @Test
    void getParser_forCommand_help_returnsHelpCommandParser() {
        assertTrue(commandParserDecorator.getParser("help") instanceof HelpCommandParser);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "hello", "Hello", "not-help", "r___d20+1", "roller dex"})
    void getParser_commandNotRecognized_returnsNoCommandParser(String mainCommand) {
        assertTrue(commandParserDecorator.getParser(mainCommand) instanceof NoCommandParser);
    }
}

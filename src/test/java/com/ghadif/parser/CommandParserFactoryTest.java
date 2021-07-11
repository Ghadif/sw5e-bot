package com.ghadif.parser;

import com.ghadif.CustomTestConfiguration;
import com.ghadif.exception.NotACommandException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import({CustomTestConfiguration.class})
public class CommandParserFactoryTest {

    @Autowired
    private CommandParserFactory commandParserFactory;

    @Test
    void getParser_forCommand_help_returnsHelpCommandParser() {
        assertTrue(commandParserFactory.determineCommandParser("/help") instanceof HelpCommandParser);
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "/ ", "/hello", "/Hello", "/not-help", "/r___d20+1", "/roller dex"})
    void getParser_messageNotRecognized_throwsNotACommandException(String message) {
        assertThrows(NotACommandException.class,
                () -> commandParserFactory.determineCommandParser(message),
                String.format("The message passed [%s] is not a recognized command", message));
    }
}

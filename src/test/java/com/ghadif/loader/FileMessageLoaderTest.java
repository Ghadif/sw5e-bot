package com.ghadif.loader;

import com.ghadif.CustomTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import({CustomTestConfiguration.class})
public class FileMessageLoaderTest {

    @Autowired
    private FileMessageLoader fileMessageLoader;

    @Test
    void loadsMessage_fromFile_returnsHelpText() throws IOException {
        String loadedHelpText = fileMessageLoader.loadMessage("help");

        String expectedHelpText = """
                Hello, I'm the unofficial SW5e bot.
                For now, only the help command is implemented.
                You can call it from /help""";
        assertEquals(expectedHelpText, loadedHelpText);
    }
}

package com.ghadif.parser;

import com.ghadif.CustomTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Import({CustomTestConfiguration.class})
public class MessageParserListTest {

    @Autowired
    private List<CommandParser> allCommandParsers;

    @Test
    void commandParsers_getAutowiredSuccessfully() {
        assertEquals(2, allCommandParsers.size());
    }
}

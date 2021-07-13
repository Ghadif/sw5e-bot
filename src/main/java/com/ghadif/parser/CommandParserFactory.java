package com.ghadif.parser;

import com.ghadif.exception.NotACommandException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Log4j2
@Service
@RequiredArgsConstructor
public class CommandParserFactory {

    private final List<CommandParser> allCommandParsers;

    public CommandParser getCommandParserForMessage(String messageContent) {
        return this.determineCommandParser(messageContent);
    }

    CommandParser determineCommandParser(String messageContent) {
        return allCommandParsers.stream()
                .filter(commandParser -> messageContent.matches(commandParser.getPatternMatcher()))
                .findAny()
                .orElseThrow(() -> {
                    log.warn("The message passed [{}] is not a recognized command", messageContent);
                    return new NotACommandException("The message passed [%s] is not a recognized command", messageContent);
                });

    }
}

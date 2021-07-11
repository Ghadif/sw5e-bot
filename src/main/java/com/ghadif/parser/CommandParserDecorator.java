package com.ghadif.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Service
@RequiredArgsConstructor
public class CommandParserDecorator implements CommandParser {

    private final HelpCommandParser helpCommandParser;
    private final NoCommandParser noCommandParser;

    CommandParser getParser(String mainCommand) {
        mainCommand = mainCommand.replace("/", "");
        return switch (mainCommand) {
            case "help" -> helpCommandParser;
            default -> noCommandParser;
        };
    }

    @Override
    public String parseCommand(String command) {
        return this.getParser(command).parseCommand(command);
    }
}

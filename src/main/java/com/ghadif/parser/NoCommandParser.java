package com.ghadif.parser;

import org.springframework.stereotype.Service;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Service
public class NoCommandParser implements CommandParser {
    @Override
    public String parseCommand(String command) {
        return "";
    }
}

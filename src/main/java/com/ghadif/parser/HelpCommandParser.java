package com.ghadif.parser;

import com.ghadif.loader.FileMessageLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Service
@RequiredArgsConstructor
public class HelpCommandParser implements CommandParser {

    private final FileMessageLoader fileMessageLoader;

    @Override
    public String parseCommand(String command) {
        return fileMessageLoader.load("help");
    }
}

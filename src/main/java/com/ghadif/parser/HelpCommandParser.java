package com.ghadif.parser;

import com.ghadif.configuration.PatternMatcherSupplier;
import com.ghadif.loader.FileMessageLoader;
import org.springframework.stereotype.Service;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@Service
public class HelpCommandParser extends CommandParser {

    private final FileMessageLoader fileMessageLoader;

    public HelpCommandParser(PatternMatcherSupplier patternMatcherSupplier, FileMessageLoader fileMessageLoader) {
        super(patternMatcherSupplier);
        this.fileMessageLoader = fileMessageLoader;
    }

    @Override
    public String getPatternMatcher() {
        return patternMatcherSupplier.getHelp();
    }

    @Override
    public String parseCommand(String command) {
        return fileMessageLoader.load("help");
    }
}

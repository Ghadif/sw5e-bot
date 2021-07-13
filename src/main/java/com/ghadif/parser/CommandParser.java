package com.ghadif.parser;

import com.ghadif.configuration.PatternMatcherSupplier;
import lombok.RequiredArgsConstructor;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@RequiredArgsConstructor
public abstract class CommandParser {

    protected final PatternMatcherSupplier patternMatcherSupplier;

    public abstract String parseCommand(String command);
    abstract String getPatternMatcher();
}

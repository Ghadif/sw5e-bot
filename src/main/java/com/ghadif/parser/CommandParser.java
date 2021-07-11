package com.ghadif.parser;

import com.ghadif.configuration.PatternMatcherSupplier;
import lombok.RequiredArgsConstructor;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
@RequiredArgsConstructor
public abstract class CommandParser {

    protected final PatternMatcherSupplier patternMatcherSupplier;

    abstract String getPatternMatcher();
    abstract String parseCommand(String command);
}

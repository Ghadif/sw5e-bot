package com.ghadif.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class CustomDisplayNameGeneratorTest {

    @Test
    void replaceAllUnderscores_capitalizesWords_replacesUnderscores_removesParentheses_returnsString() {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName()
                .concat("()");

        String replacedMethodName = CustomDisplayNameGenerator.ReplaceCamelCaseAndUnderscores
                .replaceAllCamelCaseAndUnderscores(methodName);

        String expectedMethodName = "ReplaceAllUnderscores - CapitalizesWords - ReplacesUnderscores - RemovesParentheses ==> ReturnsString";

        assertEquals(expectedMethodName, replacedMethodName);
    }
}

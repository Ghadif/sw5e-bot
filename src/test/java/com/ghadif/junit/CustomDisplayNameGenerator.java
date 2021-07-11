package com.ghadif.junit;

import org.apache.commons.text.WordUtils;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

/**
 * @author Ghadi Freiha, alias Darth Cras
 */
public class CustomDisplayNameGenerator {

    static class ReplaceCamelCaseAndUnderscores extends DisplayNameGenerator.Standard {

        @Override
        public String generateDisplayNameForClass(Class<?> testClass) {
            return replaceAllCamelCaseAndUnderscores(super.generateDisplayNameForClass(testClass));
        }

        @Override
        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return replaceAllCamelCaseAndUnderscores(super.generateDisplayNameForNestedClass(nestedClass));
        }

        @Override
        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return replaceAllCamelCaseAndUnderscores(testMethod.getName())
                    .concat(DisplayNameGenerator.parameterTypesAsString(testMethod));
        }

        static String replaceAllCamelCaseAndUnderscores(String testName) {
            return WordUtils
                    .capitalize(testName
                            .replaceAll("_returns", " ==> returns")
                            .replaceAll("_", " - ")
                            .replaceAll("\\(\\)", ""));
        }
    }
}

package com.company.Server;

/**
 *  ParseAll class
 *transforms  the string values to the primitive types
 * @author Francisco Estrella
 * @version 0.1
 */
public class ParseAll {
    public static int tryParseInt(String value, int defaultVal, StringBuilder stringBuilder) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            stringBuilder.append(e.getMessage());
            return defaultVal;
        }
    }
}

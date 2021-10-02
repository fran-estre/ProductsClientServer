package com.company.Shared.Commands;

import java.util.Locale;

public class DataBoxHandler {
    public static boolean getDataBox(String[] parts, Command command, StringBuilder comments, boolean isInteractive) {
        DataBox dataBox = null;
        try {
            Class cls = Class.forName("com.company.Shared.Commands.Prepare" + getClassName(parts[0]));
            PrepareCommand myTestObject = (PrepareCommand) cls.newInstance();
            return myTestObject.execute(isInteractive, command, dataBox, parts, comments);
        } catch (ClassNotFoundException e) {
            comments.append("unknown command");
        } catch (InstantiationException e) {
            comments.append("an InstantiationException arise");
        } catch (IllegalAccessException e) {
            comments.append("an IllegalAccessException arise");
        }
        return false;
    }

    private static String getClassName(String part) {
        StringBuilder className = new StringBuilder();
        className.append(Character.toString(part.charAt(0)).toUpperCase(Locale.ROOT));
        for (int actual = 1; actual < part.length(); actual++) {
            if (part.charAt(actual) == '_') {
                continue;
            }
            if (part.charAt(actual - 1) == '_') {
                className.append(Character.toString(part.charAt(actual)).toUpperCase(Locale.ROOT));
            } else {
                className.append(Character.toString(part.charAt(actual)).toLowerCase(Locale.ROOT));
            }
        }
        return className.toString();
    }
}
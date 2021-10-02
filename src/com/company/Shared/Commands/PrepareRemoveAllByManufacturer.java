package com.company.Shared.Commands;

public class PrepareRemoveAllByManufacturer extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.REMOVE_ALL_BY_MANUFACTURER);
        dataBox = readDataCommandId(parts, comments);
        command.setDataCommand(dataBox);
        return dataBox != null;
    }

    private DataBox readDataCommandId(String[] parts, StringBuilder comments) {
        if (parts.length < 2) {
            comments.append("The command is incomplete, you need to enter the price.");
            return null;
        }
        DataBox dataBox = new DataBox();
        try {
            dataBox.setManufacturer(parts[1]);
        } catch (NumberFormatException e) {
            comments.append("The command is invalid.");
            return null;
        }
        return dataBox;
    }
}

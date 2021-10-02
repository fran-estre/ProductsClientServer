package com.company.Shared.Commands;

public class PreparePrintFieldAscendingManufacturer extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.PRINT_FIELD_ASCENDING_MANUFACTURER);
        return true;
    }
}

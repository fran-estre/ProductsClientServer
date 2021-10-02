package com.company.Shared.Commands;

public class PrepareInfo extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.INFO);
        return true;
    }
}

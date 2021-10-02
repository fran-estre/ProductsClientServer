package com.company.Shared.Commands;

public class PrepareShow extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.SHOW);
        return true;
    }
}

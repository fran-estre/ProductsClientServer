package com.company.Shared.Commands;

public class PrepareRemoveLast extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.REMOVE_LAST);
        return true;
    }
}

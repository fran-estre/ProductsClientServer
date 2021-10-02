package com.company.Shared.Commands;

public class PrepareHelp extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.HELP);
        return true;
    }
}

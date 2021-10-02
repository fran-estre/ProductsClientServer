package com.company.Shared.Commands;

public class PrepareGroupCountingByPartNumber extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        command.setCommandType(CommandType.GROUP_COUNTING_BY_PART_NUMBER);
        return true;
    }
}

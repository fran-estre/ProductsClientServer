package com.company.Shared.Commands;

import java.io.Serializable;


public class Command implements Serializable {
    private DataBox dataBox;
    private CommandType commandType;

    public Command() {

    }

    public DataBox getDataBox() {
        return dataBox;
    }

    public void setDataBox(DataBox dataBox) {
        this.dataBox = dataBox;
    }

    public CommandType getCommandType() {
        return commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }
}



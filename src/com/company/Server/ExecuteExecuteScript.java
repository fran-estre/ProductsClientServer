package com.company.Server;

import com.company.Shared.Commands.Command;
import com.company.Shared.Commands.DataBoxHandler;

public class ExecuteExecuteScript extends ExecuteCommand {

    @Override
    public String execute(Command command) {

        StringBuilder dataFile = new StringBuilder();
        dataFile.append(command.getDataBox().getDataFile());
        if (dataFile.length() <= 0) {
            return "The file was empty.";
        }

        String line;
        StringBuilder output = new StringBuilder();

        while (!(line = getLine(dataFile)).isEmpty()) {
            output.append("\n").append(line).append("\n");
            output.append(executeCommand(line));
        }
        return output.toString();

    }

    private String getLine(StringBuilder dataFile) {
        String line;
        if (dataFile.indexOf("\n") > 0) {
            line = dataFile.substring(0, dataFile.indexOf("\n"));
            dataFile.delete(0, dataFile.indexOf("\n") + 1);
        } else {
            line = dataFile.toString();
            dataFile.setLength(0);
        }
        return line;
    }

    public String executeCommand(String currentCommand) {
        String[] parts = currentCommand.toUpperCase().split(" ");
        Command command = new Command();
        StringBuilder comments = new StringBuilder();
        if (DataBoxHandler.getDataBox(parts, command, comments, false))
            return ProcessHandler.processCommand(command);
        else
            return comments.toString();
    }
}

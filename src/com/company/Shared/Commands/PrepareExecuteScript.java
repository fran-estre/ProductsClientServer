package com.company.Shared.Commands;


import com.company.Shared.FileReader;

public class PrepareExecuteScript extends PrepareCommand {

    @Override
    public boolean execute(boolean isInteractive, Command command, DataBox dataBox, String[] parts, StringBuilder comments) {
        if (!isInteractive)
            return false;

        command.setCommandType(CommandType.EXECUTE_SCRIPT);
        dataBox = readDataCommandExecuteScript(parts, comments);
        command.setDataCommand(dataBox);
        return dataBox != null;
    }


    private static DataBox readDataCommandExecuteScript(String[] parts, StringBuilder comments) {
        if (parts.length < 2) {
            comments.append("The command is incomplete, you need to enter the filename that contain the commands.");
            return null;
        }
        FileReader fileReader = new FileReader();
        String dataFile = fileReader.read(parts[1]);
        if (dataFile == null) {
            comments.append("Can't read the file.");
            return null;
        }
        DataBox dataBox = new DataBox();
        dataBox.setDataFile(dataFile);
        return dataBox;
    }
}

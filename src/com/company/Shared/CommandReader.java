package com.company.Shared;

import java.util.Scanner;

public class CommandReader {
    public void readConsoleCommand() {
        String currentCommand;
        Scanner keyboard = new Scanner(System.in);
        CommandSender commandSender = new CommandSender();

        System.out.print("\nEnter the command: ");
        while (!((currentCommand = keyboard.nextLine().toUpperCase()).equals("EXIT"))) {
            String[] parts = currentCommand.split(" ");
            Command command = new Command();
            StringBuilder comments = new StringBuilder();
            if (DataBoxHandler.getDataBox(parts, command, comments, true)) {
                String result = commandSender.sendCommand(command);
                System.out.println(result);
            } else
                System.out.println(comments);
            System.out.print("\nEnter the new command: ");
        }
    }

}

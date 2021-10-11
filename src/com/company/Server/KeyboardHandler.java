package com.company.Server;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class KeyboardHandler implements Runnable {
    public void run() {
        String data;
        Scanner scanner = new Scanner(System.in);
        System.out.println("SAVE: to save file\nEXIT: to finish execution");
        while (!(data = scanner.nextLine().toUpperCase()).equals("EXIT")) {
            if (data.equals("SAVE")) {
                ExecuteSave executeSave = new ExecuteSave();
                try {
                    System.out.println(executeSave.execute(null));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                System.out.println("Saving file...");
                System.out.println("SAVE: to save data\nEXIT: to finish execution");
            }
        }
        ServerApp.setExit(true);
    }
}
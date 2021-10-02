package com.company.Client;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientApp {
    private static Communication communication;

    public static Communication getCommunication() {
        return ClientApp.communication;
    }

    private static void setCommunication(Communication communication) {
        ClientApp.communication = communication;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String serverAddress;
        int port;

        do {
            if (args.length == 2) {
                serverAddress = args[0];
                port = Integer.parseInt(args[1]);
                args= new String[0];
            } else {
                System.out.print("Enter the server address: ");
                serverAddress = scanner.nextLine();
                System.out.print("Enter the port: ");
                port = Integer.parseInt(scanner.nextLine());
            }

            if (initializeCommunication(serverAddress, port)) {
                new CommandReader().readConsoleCommand();
                return;
            } else
                System.out.println("Would you like to try again (yes/no)?");
        } while (scanner.nextLine().equalsIgnoreCase("YES"));
    }

    private static Boolean initializeCommunication(String serverAddress, Integer port) {
        try {
            setCommunication(new Communication(serverAddress, port));
            return true;
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("There was an exception while connecting to the server. " + e.getMessage());
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("There was an unknown exception. " + e.getMessage());
        }
        return false;
    }
}

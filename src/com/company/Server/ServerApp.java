package com.company.Server;

import com.company.Shared.Entities.Product;
import com.company.Shared.JsonReader;

import java.io.File;
import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Vector;

public class ServerApp {
    public static Vector<Product> products = new Vector<>();
    private static String fileName;
    private static String initialization;
    private static Boolean exit = false;

    public static Boolean getExit() {
        return exit;
    }

    public static void setExit(Boolean exit) {
        ServerApp.exit = exit;
        if (exit) System.exit(0);
    }

    public static String getFileName() {
        return fileName;
    }

    private static void setFileName(String fileName) {
        ServerApp.fileName = fileName;
    }

    public static String getInitialization() {
        return initialization;
    }

    public static void setInitialization(String initialization) {
        ServerApp.initialization = initialization;
    }

    public static void main(String[] args) {
        int port;
        if (args.length == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the port: ");
            port = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter the file name: ");
            setFileName(scanner.nextLine());
        } else {
            port = Integer.parseInt(args[0]);
            setFileName(args[1]);
        }
        File f = new File(fileName);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        if (!f.exists()) {
            try {
                f.createNewFile();
                setFileName(fileName);
            } catch (IOException e) {
                System.out.println("Couldn't create file.");
                e.printStackTrace();
            }
        } else {
            products = new JsonReader().read(fileName);
            if (products == null) {
                System.out.println("There was a problem reading the file.");
                return;
            }
        }
        initialization = sdf.format(f.lastModified());
        try {
            KeyboardHandler keyboardHandler = new KeyboardHandler();
            Thread t1 = new Thread(keyboardHandler);
            t1.start();

            Communication communication = new Communication(port);
            communication.listen();
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("There was a socket exception. " + e.getMessage());
        }
    }
}

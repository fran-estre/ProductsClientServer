package com.company.Shared;

import com.company.Shared.Entities.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * JsonReader class
 * helps read the file with the scanner
 * @author Francisco Estrella
 * @version 0.1
 */
public class JsonReader {

    public Vector<Product> read1(String fileName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        String line;
        String data = "";
        try {
            while ((line = reader.readLine()) != null) {
                data = data + line;
            }
            ProductGetter productReader = new ProductGetter();
            return productReader.read(data);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Vector<Product> read(String fileName) {
        Scanner reader;
        try {
            reader = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        String line;
        String data = "";

        while (reader.hasNextLine()) {
            line= reader.nextLine();
            data = data + line;
        }
        ProductGetter productReader = new ProductGetter();
        return productReader.read(data);
    }


}

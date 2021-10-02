package com.company.Shared;

import com.company.Shared.Entities.*;

import java.util.Locale;
import java.util.Scanner;

public class ProductReader {
    public Product createProduct() {
        Scanner keyboard = new Scanner(System.in);
        String name;
        do {
            System.out.println("Enter product name: ");
            name = keyboard.next();
            if (name.isEmpty()) {
                name = null;
            }
            if (name == null) {
                System.out.println("The name is invalid.");
            }
        } while (name == null);

        int price;
        do {
            System.out.println("Enter product price: ");
            price = readInteger(keyboard, "Enter the correct value for the price.");
            if (price <= 0) {
                System.out.println("The price is invalid.");
            }
        } while (price <= 0);

        String partNumber;
        do {
            System.out.println("Enter partNumber,the first character must be a letter: ");
            partNumber = keyboard.next();
            if (partNumber.isEmpty()) {
                partNumber = null;
            }
            if (partNumber == null) {
                System.out.println("The partNumber is invalid.");
            }
        } while (partNumber == null);

        Coordinates coordinates = createCoordinates(keyboard);
        Organization manufacturer = createOrganization(keyboard);
        UnitOfMeasure unitOfMeasure = createUnitOfMeasure(keyboard);

        return new Product(name, coordinates, price, partNumber, unitOfMeasure, manufacturer);
    }

    public static Integer readInteger(Scanner keyboard, String message) {
        while (true) {
            String value = keyboard.next();
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        }
    }

    private static Coordinates createCoordinates(Scanner keyboard) {
        double x;
        do {
            System.out.println("Enter coordinate x: ");

            x = readDouble(keyboard, "Enter the correct value for the coordinate.");
            if (x < -656) {
                System.out.println("The coordinate is invalid.");
            }
        } while (x < -656);

        double y;
        do {
            System.out.println("Enter coordinate y: ");
            y = readDouble(keyboard, "Enter the correct value for the coordinate.");
            if (y < -816) {
                System.out.println("The coordinate is invalid.");
            }
        } while (y < -816);

        Coordinates coordinates = new Coordinates();
        coordinates.setX(x);
        coordinates.setY(y);
        return coordinates;
    }

    public static Double readDouble(Scanner keyboard, String message) {
        while (true) {
            String value = keyboard.next();
            try {
                return Double.parseDouble(value);
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        }
    }

    private static Organization createOrganization(Scanner keyboard) {
        String name;
        do {
            System.out.println("Enter manufacturer name: ");
            name = keyboard.next();
            if (name.isEmpty()) {
                name = null;
            }
            if (name == null) {
                System.out.println("The name is invalid.");
            }
        } while (name == null);

        String fullName;
        do {
            System.out.println("Enter manufacturer  full name: ");
            fullName = keyboard.next();
            if (fullName.isEmpty()) {
                fullName = null;
            }
            if (fullName == null || fullName.length() > 1014) {
                System.out.println("The full name is invalid.");
            }
        } while (fullName == null || fullName.length() > 1014);

        float annualTurnover;
        do {
            System.out.println("Enter annual turn over : ");
            annualTurnover = readFloat(keyboard, "Enter the correct value.");
            if (annualTurnover <= 0) {
                System.out.println("The annual turn over is invalid.");
            }
        } while (annualTurnover <= 0);

        long employeesCount;
        do {
            System.out.println("Enter employees count ");
            employeesCount = readLong(keyboard, "Enter the correct value for the employees count .");
            if (employeesCount <= 0) {
                System.out.println("The employees count  is invalid.");
            }
        } while (employeesCount <= 0);

        Address address = createAddress(keyboard);
        Organization organization = new Organization();
        organization.setName(name);
        organization.setFullName(fullName);
        organization.setAnnualTurnover(annualTurnover);
        organization.setEmployeesCount(employeesCount);
        organization.setOfficialAddress(address);
        return organization;
    }

    public static Float readFloat(Scanner keyboard, String message) {
        while (true) {
            String value = keyboard.next();
            try {
                return Float.parseFloat(value);
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        }
    }

    public static Long readLong(Scanner keyboard, String message) {
        while (true) {
            String value = keyboard.next();
            try {
                return Long.parseLong(value);
            } catch (NumberFormatException e) {
                System.out.println(message);
            }
        }
    }

    private static Address createAddress(Scanner keyboard) {
        String zipCode;
        do {
            System.out.println("Enter zip code: ");

            zipCode = keyboard.next();

            if (zipCode.isEmpty()) {
                zipCode = null;
            }
            if (zipCode == null || zipCode.length() > 30) {
                System.out.println("The zip code is invalid.");
            }
        } while (zipCode == null || zipCode.length() > 30);

        Location location = createLocation(keyboard);

        Address address = new Address();
        address.setZipCode(zipCode);
        address.setTown(location);
        return address;
    }

    private static Location createLocation(Scanner keyboard) {
        Double x;
        do {
            System.out.println("Enter coordinate x: ");
            x = readDouble(keyboard, "Enter the correct value for the coordinate.");
        } while (x == null);
        Long y;
        do {
            System.out.println("Enter coordinate y ");
            y = readLong(keyboard, "Enter the correct value for  the coordinate.");
            if (y == null) {
                System.out.println("The coordinate is invalid.");
            }
        } while (y == null);

        Long z;
        do {
            System.out.println("Enter coordinate z ");
            z = readLong(keyboard, "Enter the correct value for the coordinate.");
            if (z == null) {
                System.out.println("The coordinate is invalid.");
            }
        } while (z == null);

        Location location = new Location();
        location.setX(x);
        location.setY(y);
        location.setZ(z);
        return location;
    }

    private static UnitOfMeasure createUnitOfMeasure(Scanner keyboard) {
        String value;
        UnitOfMeasure unitOfMeasure = null;
        do {
            System.out.println("Enter unit of measure (METERS, CENTIMETERS, SQUARE_METERS, MILLILITERS, MILLIGRAMS):");
            value = keyboard.next().toLowerCase(Locale.ROOT);
            switch (value) {
                case "meters" -> unitOfMeasure = UnitOfMeasure.METERS;
                case "centimeters" -> unitOfMeasure = UnitOfMeasure.CENTIMETERS;
                case "square_meters" -> unitOfMeasure = UnitOfMeasure.SQUARE_METERS;
                case "milliliters" -> unitOfMeasure = UnitOfMeasure.MILLILITERS;
                case "milligrams" -> unitOfMeasure = UnitOfMeasure.MILLIGRAMS;
                default -> System.out.println("The unit of measure is invalid.");
            }
        } while (unitOfMeasure == null);
        return unitOfMeasure;
    }
}

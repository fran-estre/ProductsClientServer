package com.company.Shared.Entities;

import java.io.Serializable;

/**
 * Address class
 * the address of the organization
 * @author Francisco Estrella
 * @version 0.1
 */
public class Address implements Serializable {
    private String zipCode; //Длина строки не должна быть больше 30, Поле не может быть null
    private Location town; //Поле может быть null

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    public String toJson() {
        String zipCodeJson = String.format("\"zipCode\":\"%s\",", getZipCode());
        String townJson = getTown().toJson();
        return String.format("\"town\":{%s%s}", zipCodeJson, townJson);
    }
}

package com.company.Shared.Entities;

import java.io.Serializable;

/**
 * Location class
 *location of the organization
 * @author Francisco Estrella
 * @version 0.1
 */
public class Location implements Serializable {
    private double x;
    private long y;
    private Long z; //Поле не может быть null

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    public Long getZ() {
        return z;
    }

    public void setZ(Long z) {
        this.z = z;
    }

    public String toJson() {
        String xJson = String.format("\"x\":\"%s\",", getX());
        String yJson = String.format("\"y\":\"%s\",", getY());
        String zJson = String.format("\"z\":\"%s\"", getZ());

        return String.format("\"location\":{%s%s%s}", xJson, yJson,zJson);
    }
}

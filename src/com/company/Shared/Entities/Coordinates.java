package com.company.Shared.Entities;

import java.io.Serializable;

/**
 * Coordinates class
 *  the address of the product
 * @author Francisco Estrella
 * @version 0.1
 */
public class Coordinates implements Serializable {
    private Double x; //Значение поля должно быть больше -656, Поле не может быть null
    private Double y; //Значение поля должно быть больше -816, Поле не может быть null

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }
    public String toJson() {
        String xJson = String.format("\"x\":\"%s\",", getX());
        String yJson = String.format("\"y\":\"%s\"", getY());

        return String.format("\"coordinates\":{%s%s},", xJson, yJson);
    }
}

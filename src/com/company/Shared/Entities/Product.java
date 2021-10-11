package com.company.Shared.Entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * Product class
 * instances the product
 *
 * @author Francisco Estrella
 * @version 0.1
 */
public class Product implements Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer price; //Поле может быть null, Значение поля должно быть больше 0
    private String partNumber; //Значение этого поля должно быть уникальным, Строка не может быть пустой, Поле может быть null
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле может быть null


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return partNumber.equals(product.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(partNumber);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public Organization getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Organization manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String toString() {
        return String.format("id: %s, name: %s", getId(), getName());
    }

    /**
     * this constructor is called  by objectMapper using reflection so do not delete it
     */
    public Product() {
    }

    public Product(String name, Coordinates coordinates, Integer price, String partNumber, UnitOfMeasure unitOfMeasure, Organization manufacturer) {
        setName(name);
        setCoordinates(coordinates);
        setPrice(price);
        setPartNumber(partNumber);
        setUnitOfMeasure(unitOfMeasure);
        setManufacturer(manufacturer);
        setCreationDate(getDate());
    }

    private Date getDate() {
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        return Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
    }

    public String toJson() {
        String idJson = String.format("\"id\":\"%s\",", getId());
        String nameJson = String.format("\"name\":\"%s\",", getName());
        String coordinatesJson = getCoordinates().toJson();
        String creationDateJson = String.format("\"creationDate\":\"%s\",", getCreationDate());
        String priceJson = String.format("\"price\":\"%s\",", getPrice());
        String partNumberJson = String.format("\"partNumber\":\"%s\",", getPartNumber());
        String unitOfMeasureJson = String.format("\"unitOfMeasure\":\"%s\",", getUnitOfMeasure());
        String manufacturerJson = getManufacturer().toJson();
        return String.format("{%s%s%s%s%s%s%s%s}",
                idJson,
                nameJson,
                coordinatesJson,
                creationDateJson,
                priceJson,
                partNumberJson,
                unitOfMeasureJson,
                manufacturerJson);
    }
}
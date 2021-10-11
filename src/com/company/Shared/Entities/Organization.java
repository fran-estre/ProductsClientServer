package com.company.Shared.Entities;

import java.io.Serializable;

/**
 * Organization class
 * instances the organization of the product
 * @author Francisco Estrella
 * @version 0.1
 */
public class Organization implements Serializable {
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private String fullName; //Значение этого поля должно быть уникальным, Длина строки не должна быть больше 1014, Поле не может быть null
    private float annualTurnover; //Значение поля должно быть больше 0
    private long employeesCount; //Значение поля должно быть больше 0
    private Address officialAddress; //Поле не может быть null

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public float getAnnualTurnover() {
        return annualTurnover;
    }

    public void setAnnualTurnover(float annualTurnover) {
        this.annualTurnover = annualTurnover;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public Address getOfficialAddress() {
        return officialAddress;
    }

    public void setOfficialAddress(Address officialAddress) {
        this.officialAddress = officialAddress;
    }

    public String toJson() {
        String idJson = String.format("\"id\":\"%s\",", getId());
        String nameJson = String.format("\"name\":\"%s\",", getName());
        String fullNameJson = String.format("\"fullName\":\"%s\",", getFullName());
        String annualTurnOverJson = String.format("\"annualTurnover\":\"%s\",", getAnnualTurnover());
        String employeesCountJson = String.format("\"employeesCount\":\"%s\",", getEmployeesCount());
        String officialAddressJson = getOfficialAddress().toJson();

        return String.format("\"manufacturer\":{%s%s%s%s%s%s}", idJson, nameJson,fullNameJson,annualTurnOverJson,employeesCountJson,officialAddressJson);
    }
}

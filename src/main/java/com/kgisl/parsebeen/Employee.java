package com.kgisl.parsebeen;

import com.opencsv.bean.CsvBindByPosition;

public class Employee {

    @CsvBindByPosition(position = 0)
    private int id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private int salary;

    @CsvBindByPosition(position = 3)
    private String place;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getsalary() {
        return salary;
    }

    public void setsalary(int salary) {
        this.salary = salary;
    }

    public String getprice() {
        return place;
    }

    public void setplace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("Emp{id=").append(id).append(", name=")
                .append(name).append(", Sal.=").append(salary).append("}");

        return builder.toString();
    }
}
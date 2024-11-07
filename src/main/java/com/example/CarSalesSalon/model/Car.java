package com.example.CarSalesSalon.model;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brend; // Производитель
    private String model; // Модель
    private String carClass; //Класс автомобилей
    private int year; // Год выпуска
    private double price; // Цена автомобиля

    // Конструкторы, геттеры и сеттеры

    public Car() {
    }

    public Car(String brend, String model, String carClass, int year, double price) {
        this.brend = brend;
        this.model = model;
        this.carClass = carClass;
        this.year = year;
        this.price = price;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }
}

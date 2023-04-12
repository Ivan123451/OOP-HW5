package org.example;

public class CellPhone {
    String brand;
    String model;

    int price;

    public CellPhone(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    @Override
    public String toString() {
        return " телефон " +
                "марки= '" + brand + '\'' +
                ", модель = '" + model + '\'' +
                ", цена = " + price +
                '}';
    }
}

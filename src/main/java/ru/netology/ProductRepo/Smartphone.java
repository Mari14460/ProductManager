package ru.netology.ProductRepo;

import ru.netology.ProductRepo.Product;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone(int id, String name, double price, String manufacture) {
        super(id, name, price);
        this.manufacture = manufacture;
    }
}

package ru.netology.ProductRepo;

import ru.netology.ProductRepo.Product;

public class Book extends Product {
    private String author;

    public Book(int id, String name, double price, String author) {
        super(id, name, price);
        this.author = author;
    }
}

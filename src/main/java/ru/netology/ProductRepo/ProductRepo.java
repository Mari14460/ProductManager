package ru.netology.ProductRepo;

import ru.netology.ProductManager.NotFoundException;

public class ProductRepo {
    private Product[] products = new Product[0];

    public void addProduct(Product product) {
        Product[] temp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            temp[i] = products[i];
        }
        temp[products.length] = product;
        products = temp;
    }

    public Product[] findAll() {
        return products;
    }

    public Product findById(int id){
        for (Product product : products) {
            if (product.getId() == id){
               return product;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        if (findById(id) == null){
            throw new NotFoundException("Product with id=" + id + " doesn't exist");
        }
        Product[] temp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id){
                temp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = temp;
    }
}

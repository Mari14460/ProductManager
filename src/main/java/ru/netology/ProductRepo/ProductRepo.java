package ru.netology.ProductRepo;

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

    public void deleteById(int id) {
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

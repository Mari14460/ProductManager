package ru.netology.ProductManager;

import ru.netology.ProductRepo.Product;
import ru.netology.ProductRepo.ProductRepo;

public class ProductManager {

    ProductRepo repository;

    public ProductManager(ProductRepo repository) {
        this.repository = repository;
    }

    public void addProductToRepo(Product product){
        repository.addProduct(product);
    }

    public void deleteProductFromRepoById(int id){
        repository.deleteById(id);
    }

    public Product[] findAll(){
        return repository.findAll();
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] temp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    temp[i] = result[i];
                }
                temp[result.length] = product;
                result = temp;
            }
        }
        return result;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getName().contains(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}

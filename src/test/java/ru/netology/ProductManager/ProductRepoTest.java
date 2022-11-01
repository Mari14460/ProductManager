package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductRepo.Book;
import ru.netology.ProductRepo.Product;
import ru.netology.ProductRepo.ProductRepo;
import ru.netology.ProductRepo.Smartphone;

public class ProductRepoTest {

    ProductRepo productRepo = new ProductRepo();
    Product product = new Product(1, "Watch", 45.90);
    Product book = new Book(2, "Plague", 11.99, "Tolstoy");
    Product phone = new Smartphone(3, "iPhone", 1233.55, "Apple");

    @BeforeEach
    public void setup () {
        productRepo.addProduct(product);
        productRepo.addProduct(book);
        productRepo.addProduct(phone);
    }

    @Test
    void shouldReturnAll() {
        Product[] expected = {product, book, phone};
        Product[] actual = productRepo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addOneProduct() {
        Product nokia = new Smartphone(4, "Nokia", 600.00, "Nokia");
        productRepo.addProduct(nokia);

        Product[] expected = {product, book, phone, nokia};
        Product[] actual = productRepo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteOneProduct() {
        productRepo.deleteById(2);
        Product[] expected = {product, phone};
        Product[] actual = productRepo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteProductNotExists() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            productRepo.deleteById(5);
        });
    }
}

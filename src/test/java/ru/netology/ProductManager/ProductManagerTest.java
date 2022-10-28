package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.ProductRepo.Book;
import ru.netology.ProductRepo.Product;
import ru.netology.ProductRepo.ProductRepo;
import ru.netology.ProductRepo.Smartphone;

public class ProductManagerTest {

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
        ProductManager productManager = new ProductManager(productRepo);

        Product[] expected = {product, book, phone};
        Product[] actual = productManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void addOneProduct() {
        Product nokia = new Smartphone(4, "Nokia", 600.00, "Nokia");

        ProductManager productManager = new ProductManager(productRepo);
        productManager.addProductToRepo(nokia);

        Product[] expected = {product, book, phone, nokia};
        Product[] actual = productManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void deleteOneProduct() {
        ProductManager productManager = new ProductManager(productRepo);
        productManager.deleteProductFromRepoById(2);

        Product[] expected = {product, phone};
        Product[] actual = productManager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchProductOnlyOne() {
        ProductManager productManager = new ProductManager(productRepo);

        Product[] expected  = {phone};
        Product[] actual = productManager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void searchProductTwo() {
        ProductManager productManager = new ProductManager(productRepo);
        Product phone2 = new Smartphone(4, "iPhone", 800.00, "Apple");
        productManager.addProductToRepo(phone2);
        Product[] expected  = {phone, phone2};
        Product[] actual = productManager.searchBy("iPhone");

        Assertions.assertArrayEquals(expected, actual);
    }
}

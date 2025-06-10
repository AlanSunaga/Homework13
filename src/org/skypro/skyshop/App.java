package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

import static org.skypro.skyshop.basket.ProductBasket.*;


public class App {
    public static void main(String[] args) throws IllegalAccessException {
        Product product1 = new Product("Хлеб", 50);
        Product product2 = new Product("Молоко", 80);
        Product product3 = new Product("Сыр", 300);
        Product product4 = new Product("Чипсы", 220);
        Product product5= new Product("Газировка", 150);

        addProductName(product1);

        addProductName(product2);

        addProductName(product3);

        addProductName(product4);

        addProductName(product5);





        ProductBasket.nameString();
        System.out.println("ProductBasket.searchProduct(\"Хлеб\") = " + searchProduct("Хлеб"));
        System.out.println("ProductBasket.searchProduct(\"Бобиджон\") = " + searchProduct("Бобиджон"));

        ProductBasket.cleanBascket();

        ProductBasket.nameString();
        System.out.println("ProductBasket.searchProduct(\"Хлеб\") = " + searchProduct("Хлеб"));

    }
}
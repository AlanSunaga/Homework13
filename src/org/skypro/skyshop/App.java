package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import static org.skypro.skyshop.basket.ProductBasket.*;


public class App {
    public static void main(String[] args) throws IllegalAccessException {
        Product product1 = new SimpleProduct("Хлеб", 50);
        Product product2 = new DiscountedProduct("Молоко", 80, 50);
        Product product3 = new SimpleProduct("Сыр", 300);
        Product product4 = new FixPriceProduct("Чипсы");
        Product product5 = new DiscountedProduct("Газировка", 150, 20);

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
package org.skypro.skyshop;


import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchProduct.SearchEngine;

import static org.skypro.skyshop.basket.ProductBasket.*;


public class App {
    public static void main(String[] args) throws IllegalAccessException {
        Product product1 = null;
        Product product2 = null;
        Product product3 = null;
        Product product4 = null;
        Product product5 = null;

        try {
            product1 = new SimpleProduct("Хлеб", 50);
            product2 = new DiscountedProduct("Молоко", 80, 50);
            product3 = new SimpleProduct("Сыр", -300);
            product4 = new FixPriceProduct("Чипсы");
            product5 = new DiscountedProduct("", 50, -20);
        } catch (IllegalArgumentException e) {
            System.out.println("Заполните данные верно!");
        }

        addProductName(product1);

        addProductName(product2);

        addProductName(product3);

        addProductName(product4);

        addProductName(product5);

        try {
            nameString();
            System.out.println("ProductBasket.searchProduct(\"Хлеб\") = " + searchProduct("Хлеб"));
            System.out.println("ProductBasket.searchProduct(\"Бобиджон\") = " + searchProduct("Бобиджон"));
        } catch (IllegalAccessException e) {
            System.out.println("Невозможно вывести");
        }


        cleanBascket();

        nameString();
        System.out.println("ProductBasket.searchProduct(\"Хлеб\") = " + searchProduct("Хлеб"));

        System.out.println("SearchEngine");

        SearchEngine searchEngine = new SearchEngine(10);

        Article article1 = new Article("1", "1");
        Article article2 = new Article("2", "2");
        Article article3 = new Article("3", "3");

        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product5);
        searchEngine.add(article1);
        searchEngine.add(product4);
        searchEngine.add(article2);
        searchEngine.add(product3);
        searchEngine.add(article3);
        searchEngine.add(article2);
        searchEngine.add(product5);

        try {
            searchEngine.search("PRODUCT");
        } catch (IllegalAccessException e) {
            System.out.println("Невозможно найти ошибка");
        }


        try {
            System.out.println(searchEngine.saerchSuitable("гипс"));
        } catch (BestResultNotFound e) {
            System.out.println("Нет совпадений");
        }


    }
}
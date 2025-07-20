package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchProduct.SearchEngine;

public class App {
    public static void main(String[] args) throws IllegalAccessException {
        ProductBasket productBasket = new ProductBasket();

        Product product1 = new SimpleProduct("Хлеб", 50);
        Product product2 = new DiscountedProduct("Молоко", 80, 50);
        Product product3 = new SimpleProduct("Сыр", 300);
        Product product4 = new FixPriceProduct("Чипсы");
        Product product5 = new DiscountedProduct("Пепси", 50, 20);

        try {
            product1.getStringRepresentation();
            product2.getStringRepresentation();
            product3.getStringRepresentation();
            product4.getStringRepresentation();
            product5.getStringRepresentation();
        } catch (IllegalArgumentException e) {
            System.out.println("Заполните данные верно!");
        }

        productBasket.addProductName(product1);
        productBasket.addProductName(product2);
        productBasket.addProductName(product3);
        productBasket.addProductName(product4);
        productBasket.addProductName(product5);

        try {
            productBasket.nameString();
            System.out.println("ProductBasket.searchProduct(\"Хлеб\") = " + productBasket.searchProduct("Хлеб"));
            System.out.println("ProductBasket.searchProduct(\"Бобиджон\") = " + productBasket.searchProduct("Бобиджон"));
        } catch (IllegalAccessException e) {
            System.out.println("Невозможно вывести");
        }

//        cleanBascket();

        productBasket.printBacket();
        System.out.println("ProductBasket.searchProduct(\"Хлеб\") = " + productBasket.searchProduct("Хлеб"));

        System.out.println('\n'
                + "SearchEngine." + '\n');

        SearchEngine searchEngine = new SearchEngine();

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
            searchEngine.search("ARTICLE");
        } catch (IllegalAccessException e) {
            System.out.println('\n' + "Невозможно найти ошибка");
        }


        try {
            System.out.println(searchEngine.saerchSuitable("гипс"));
        } catch (BestResultNotFound e) {
            System.out.println('\n' + "Нет совпадений");
        }

        System.out.println('\n' + "Java Collections Framework: List" + '\n');


        System.out.println(productBasket.deletingAProductByName("Хлеб"));
        System.out.println();
        productBasket.printBacket();
        productBasket.deletingAProductByName("Картошка");

        productBasket.printBacket();


    }
}
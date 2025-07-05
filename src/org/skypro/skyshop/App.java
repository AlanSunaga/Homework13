package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.searchProduct.SearchEngine;
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

        searchEngine.search("ARTICLE");


    }
}
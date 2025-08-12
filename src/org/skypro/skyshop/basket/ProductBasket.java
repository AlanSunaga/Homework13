package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    private int sum;
    private int scoreIsSpecial = 0;
    private boolean productExist = true;

    public void addProductName(Product product) {
        products.computeIfAbsent(product.getNameProduct(), k -> new ArrayList<>()).add(product);

    }

    public double getTotalPrice() {

        return products.values().stream().flatMap(Collection::stream)
                .mapToDouble(Product::getPriceProduct)
                .sum();
    }

    public boolean productEx() {
        Stream<Product> basket = products.values().stream().flatMap(Collection::stream)
                .filter(Objects::nonNull);
        return productExist;
    }

    public void printBacket() throws IllegalAccessException {
        double sum = getTotalPrice();
        Stream<Product> basket = products.values().stream().flatMap(Collection::stream);
        if (sum == 0) {
            System.out.println("в корзине пусто");
        } else {
            System.out.println(basket.toList());
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + scoreIsSpecial);
        }
    }

    public Boolean searchProduct(String name) throws IllegalAccessException {
        try {
            return products.values().stream().flatMap(Collection::stream)
                    .allMatch(table -> table.getNameProduct().toLowerCase().contains(name.toLowerCase()));
        } catch (RuntimeException e) {
            throw new IllegalAccessException();
        }
    }

    public List<Product> deletingAProductByName(String name) {
        return products.remove(name);
    }

    public void cleanBascket() {
        products.clear();

    }

}

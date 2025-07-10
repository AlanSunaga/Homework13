package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class ProductBasket {
    static LinkedList<Product> products = new LinkedList<>();
    static List<Product> delete = new ArrayList<>();
    static int sum;
    static int index = 1;
    static int scoreIsSpecial = 0;


    public static void addProductName(Product product) {
        products.add(product);
        index++;
    }

    public static void printDeletedBasket() {
        System.out.println("Удаленный продукт " + delete);
    }


    public static int getTotalPrice() {

        if (products.get(0) == null) {
            return 0;
        } else {
            for (int i = 0; i < products.size(); i++) {
                sum += products.get(i).getPriceProduct();
            }
            return sum;
        }
    }

    public static void nameString() throws IllegalAccessException {

        if (products.get(0) != null) {
            for (Product product : products) {
                if (product == null) {
                    throw new IllegalAccessException();
                } else {
                    System.out.println(product);
                    sum += product.getPriceProduct();
                    if (product.isSpecial()) {
                        scoreIsSpecial++;
                    }
                }

            }
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + scoreIsSpecial);
        } else System.out.println("Корзина пуста");

    }

    public static void printBacket() throws IllegalAccessException {
        if (products.get(0) != null) {
            for (Product product : products) {
                if (product == null) {
                    throw new IllegalAccessException();
                } else {
                    System.out.println(product);
                }

            }
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + scoreIsSpecial);
        } else System.out.println("Корзина пуста");
    }

    public static Boolean searchProduct(String name) throws IllegalAccessException {

        if (products.get(0) == null) {
            return false;
        } else {

            for (int i = 0; i < products.size(); i++) {
                if (products.get(i) == null) {
                    throw new IllegalAccessException();
                } else if (products.get(i).getNameProduct() == name) {
                    return true;
                }
            }
            return false;
        }
    }

    public static List<Product> deletingAProductByName(String name) {
        Iterator<Product> iterator = products.iterator();


        while (iterator.hasNext()) {
            Product element = iterator.next();
            if (name == null) {
                if (element.getNameProduct() == null) {
                    iterator.remove();
                }
            } else if (name.equals(element.getNameProduct())) {
                delete.add(element);
                iterator.remove();
                return delete;
            }

        }
        System.out.println("Список пуст");
        return delete;
    }

    public static void cleanBascket() {
        for (int i = 0; i < products.size(); i++) {
            products.remove(i);
        }
    }

}

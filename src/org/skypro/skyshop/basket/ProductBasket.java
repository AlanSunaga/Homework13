package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    static Product[] products = new Product[5];
    static int sum;
    static int index = 1;
    static int scoreIsSpecial = 0;


    public static void addProductName(Product product) throws IllegalAccessException {
        if (index > products.length) {
            throw new IllegalAccessException("Невозможно добавить продукт");
        }
        products[index - 1] = product;

        index++;


    }

    public static int getTotalPrice() {

        if (products[0] == null) {
            return 0;
        } else {
            for (int i = 0; i < products.length; i++) {
                sum += products[i].getPriceProduct();
            }
            return sum;
        }
    }

    public static void nameString() {
        if (products[0] != null) {
            for (Product product : products) {
                System.out.println(product.toString());
                sum += product.getPriceProduct();
                if (product.isSpecial()) {
                    scoreIsSpecial++;
                }
            }
            System.out.println("Итого: " + sum);
            System.out.println("Специальных товаров: " + scoreIsSpecial);
        } else System.out.println("Корзина пуста");

    }

    public static Boolean searchProduct(String name) {

        if (products[0] == null) {
            return false;
        } else {

            for (int i = 0; i < products.length; i++) {
                if (products[i].getNameProduct() == name) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void cleanBascket() {
        for (int i = 0; i < products.length; i++) {
            products[i] = null;
        }
    }

}

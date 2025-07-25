package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, Product> products = new HashMap<>();

    private int sum;
    private int scoreIsSpecial = 0;
    private boolean w = true;


    public void addProductName(Product product) {
        products.put(product.getNameProduct(), product);
    }

    public int getTotalPrice() {

        for (String name : products.keySet()) {
            if (products.get(name) == null) {
                return 0;
            } else {
                for (int i = 0; i < products.size(); i++) {
                    sum += products.get(name).getPriceProduct();
                }
            }
        }

        return sum;
    }

    public boolean searchNull() {
        for (Product name : products.values()) {
            if (name == null) {
                w = false;
            }
        }
        return w;
    }

    public void nameString() throws IllegalAccessException {


        if (searchNull()) {
            for (Product product : products.values()) {
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

    public void printBacket() throws IllegalAccessException {

        if (w) {
            for (Product product : products.values()) {
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

    public Boolean searchProduct(String name) throws IllegalAccessException {

        if (!searchNull()) {
            return false;
        } else {
            for (Product product : products.values()) {
                if (product == null) {
                    throw new IllegalAccessException();
                } else if (product.getNameProduct() == name) {
                    return true;
                }
            }
            return false;
        }
    }


    public List<Product> deletingAProductByName(String name) {
        List<Product> delete = new ArrayList<>();
        for (Product product : products.values()) {
            if (product == null) {
                if (product.getNameProduct() == null) {
                    for (String productKey : products.keySet()) {
                        if (productKey.contains(product.getNameProduct())) {
                            products.remove(name);
                        }
                    }
                } else if (name.equals(product.getNameProduct())) {
                    delete.add(product);
                    System.out.println('\n' + "Список удаленных продуктов");
                    return delete;
                }
            }
        }
        System.out.println('\n' + "Список удаленных продуктов пуст" + '\n');
        return delete;
    }

    public void cleanBascket() {
        for (String productKey : products.keySet()) {
            products.remove(productKey);
        }

    }

}

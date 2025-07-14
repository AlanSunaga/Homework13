package org.skypro.skyshop.product;

import org.skypro.skyshop.searchProduct.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
        if (nameProduct == null || nameProduct.equals("")) {
            throw new IllegalArgumentException("Имя null или строка пустая");
        }
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPriceProduct();

    public boolean isSpecial() {
        return true;
    }

    @Override
    public String getSearchTerm() {
        return getNameProduct();
    }

    @Override
    public String returnTypeContent() {
        return "PRODUCT";
    }
}

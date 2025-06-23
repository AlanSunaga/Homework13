package org.skypro.skyshop.product;


import org.skypro.skyshop.searchProduct.Searchable;

public abstract class Product implements Searchable {
    private String nameProduct;


    public Product(String nameProduct) {
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
    public String searchTerm() {
        return getNameProduct();
    }

    @Override
    public String returnTypeContent() {
        return "PRODUCT";
    }
}

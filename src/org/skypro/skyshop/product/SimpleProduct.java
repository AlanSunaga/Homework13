package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    int priceProduct;

    public SimpleProduct(String nameProduct, int priceProduct) {

        super(nameProduct);
        if (priceProduct < 0) {
            throw new IllegalArgumentException();
        }
        this.priceProduct = priceProduct;
    }

    @Override
    public int getPriceProduct() {
        return priceProduct;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String toString() {
        return getNameProduct() + " : " + priceProduct;
    }
}

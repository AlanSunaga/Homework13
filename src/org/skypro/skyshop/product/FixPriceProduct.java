package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    private static final int FIX_PRICE = 100;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPriceProduct() {
        isSpecial();
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return getNameProduct() + " c фиксированной ценой: " + FIX_PRICE;
    }
}

package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    int basePrice;
    int discount;

    public DiscountedProduct(String nameProduct, int basePrice, int discount) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPriceProduct() {

        return basePrice - (basePrice * discount) / 100;
    }

    @Override
    public String toString() {
        return getNameProduct() + " : " + basePrice + '\n'
                + getNameProduct() + " со скидкой: " + getPriceProduct() + ", скидка: " + discount;
    }

}

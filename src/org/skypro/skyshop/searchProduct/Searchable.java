package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.product.Product;

public interface Searchable {
    String searchTerm();

    String returnTypeContent();


    default void getStringRepresentation() {
        System.out.println(searchTerm() + "-объекта — тип " + returnTypeContent() + "-объекта");
    }
}

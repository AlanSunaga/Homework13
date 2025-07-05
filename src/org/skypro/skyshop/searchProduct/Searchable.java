package org.skypro.skyshop.searchProduct;

public interface Searchable {
    String getSearchTerm();

    String returnTypeContent();


    default void getStringRepresentation() {
        System.out.println(getSearchTerm() + "-объекта — тип " + returnTypeContent() + "-объекта");
    }
}

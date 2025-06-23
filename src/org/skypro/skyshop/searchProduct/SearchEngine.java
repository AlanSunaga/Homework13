package org.skypro.skyshop.searchProduct;

public class SearchEngine {
    public static Searchable[] searchables;
    int index = 0;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    //Не понял как мне сделать растягивающийся размер массива при том
    // что мы в конструкторе должны указать фиксированную величину
    public String search(String s) {
        index = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i].returnTypeContent().contains(s)) {
                searchables[index] = searchables[i];
                searchables[index].getStringRepresentation();
                index++;
            } else searchables[i] = null;
        }
        return null;
    }

    public void add(Searchable searchEngine) {
        searchables[index] = searchEngine;
        index++;
    }

}

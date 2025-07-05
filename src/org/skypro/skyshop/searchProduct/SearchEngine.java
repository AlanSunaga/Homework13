package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;

public class SearchEngine {
    public static Searchable[] searchables;
    int index = 0;
    int collSowSim;

    public SearchEngine(int size) {
        searchables = new Searchable[size];
    }

    //Не понял как мне сделать растягивающийся размер массива при том
    // что мы в конструкторе должны указать фиксированную величину
    public String search(String s) throws IllegalAccessException {
        index = 0;
        for (int i = 0; i < searchables.length; i++) {
            if (searchables[i] == null) {
                throw new IllegalAccessException();
            } else if (searchables[i].returnTypeContent().contains(s)) {
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

    public Searchable saerchSuitable(String search) throws BestResultNotFound {
        Searchable searchableBest = null;
        collSowSim = 0;
        index = 0;
        int sowpad = 0;
        for (Searchable searchable : searchables) {
            if (searchable != null) {
                while ((((searchable.getSearchTerm()).toLowerCase()).indexOf(search.toLowerCase(), index)) != -1) {
                    index++;
                    collSowSim++;
                }
            }
            if (collSowSim > sowpad) {
                sowpad = collSowSim;
                searchableBest = searchable;
            }
        }
        if (searchableBest == null) {
            throw new BestResultNotFound();
        }
        return searchableBest;
    }

}

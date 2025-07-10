package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchEngine {
    public static List<Searchable> searchables = new ArrayList<>();
    int index = 0;
    int collSowSim;
    int i = 0;

    public String search(String s) throws IllegalAccessException {
        index = 0;
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) == null) {
                throw new IllegalAccessException();
            } else if (searchables.get(i).returnTypeContent().contains(s)) {
                searchables.set(index, searchables.get(i));
                searchables.get(index).getStringRepresentation();
                index++;
            } else searchables.remove(i);
        }
        return null;
    }


    public void add(Searchable searchEngine) {
        searchables.add(searchEngine);
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

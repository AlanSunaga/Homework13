package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables = new ArrayList<>();
    private int index = 0;
    private int collSowSim;

    public List<Searchable> search(String s) throws IllegalAccessException {
        List<Searchable> list = new ArrayList<>();
        index = 0;
        for (int i = 0; i < searchables.size(); i++) {
            if (searchables.get(i) == null) {
                throw new IllegalAccessException();
            } else if (searchables.get(i).returnTypeContent().contains(s)) {
                list.add(searchables.get(i));
                list.get(index).getStringRepresentation();
                index++;
            }
        }
        return list;
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

package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.SearchableComparator;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SearchEngine extends SearchableComparator {

    private Set<Searchable> searchables = new HashSet<>();
    private int index = 0;
    private int collSowSim;


    public Set<Searchable> search(String s) throws IllegalAccessException {
        return searchables.stream()
                .filter(table -> table.returnTypeContent().toLowerCase().contains(s.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
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

package org.skypro.skyshop.searchProduct;

import org.skypro.skyshop.bestResultNotFound.BestResultNotFound;
import org.skypro.skyshop.product.SearchableComparator;

import java.util.*;

public class SearchEngine extends SearchableComparator {

    private Set<Searchable> searchables = new HashSet<>();
    private int index = 0;
    private int collSowSim;


    public Set<Searchable> search(String s) throws IllegalAccessException {
        Set<Searchable> list = new TreeSet<>(new SearchableComparator());
        for (Searchable table : searchables) {
            if (table == null) {
                throw new IllegalAccessException();
            } else if (table.returnTypeContent().contains(s)) {
                list.add(table);
                table.getStringRepresentation();
            }

        }
        System.out.println('\n' + "По порядку" + '\n');
        System.out.println(list);
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

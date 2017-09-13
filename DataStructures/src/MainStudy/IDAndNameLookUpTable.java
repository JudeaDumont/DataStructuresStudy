package cs230individualproject;

import java.util.Set;

public class IDAndNameLookUpTable {

    SortLinkedStack contributorsForNameLookUp = null;
    StackChainedHashTable lookUpTable = new StackChainedHashTable(5);

    //Constructor builds the lookup table
    public IDAndNameLookUpTable(SortLinkedStack<Contributor> contributors) {
        addTableItems(contributors);
    }

    //Function adds table items
    public void addTableItems(SortLinkedStack<Contributor> contributors) {
        contributorsForNameLookUp = contributors;
        for (Contributor contributor : contributors) {
            lookUpTable.insert(Integer.toString(contributor.getId()), contributor);
        }
    }

    //Overriding the tostring method in order to help 
    //with consistent and extendible output implementation.
    @Override
    public String toString() {
        String tableAggregator = "";
        Set<Integer> keys = lookUpTable.keySet();
        for (Integer key : keys) {
            tableAggregator += "\nHashKey:" + key + "\tValues:\n";
            for (Object item : lookUpTable.table[key]) {
                tableAggregator += "\t" + item.toString() + "\n";
            }
        }
        return tableAggregator;
    }

    //Search for a specific Contributor already in the system
    public Contributor search(Contributor contributor) {
        return (Contributor) contributorsForNameLookUp.sequentialSearch(contributor);
    }

    //Search for a specific Contributor by name
    public Contributor search(String name) {
        Contributor searchContributor = new Contributor(name, null, null, null, 0, 0);
        return (Contributor) contributorsForNameLookUp.sequentialSearch(searchContributor);
    }

    //Search for a specific Contributor by ID
    public Contributor search(int id) {
        return (Contributor) lookUpTable.get(Integer.toString(id));
    }
}

package MainStudy;

import java.util.Set;

public class IDLookUpTable {

    StackChainedHashTable lookUpTable = new StackChainedHashTable(5);

    //Constructor builds the lookup table
    public IDLookUpTable(SortLinkedStack<Contributor> contributors) {
        addTableItems(contributors);
    }

    //Function adds table items
    public void addTableItems(SortLinkedStack<Contributor> contributors) {
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
}

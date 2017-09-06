package cs230individualproject;

import java.util.Set;

public class IDLookUpTable {
    ContributorLinkedStackChainedHashTable lookUpTable = new ContributorLinkedStackChainedHashTable(5);
    
    //Constructor builds the lookup table
    public IDLookUpTable(ContributorLinkedStack contributors) {
        addTableItems(contributors);
    }
    
    //Function adds table items
    public void addTableItems(ContributorLinkedStack contributors)
    {
        for(Contributor contributor : contributors )
        {
            lookUpTable.insert(Integer.toString(contributor.getId()), contributor);
        }
    }
    
    @Override
    public String toString()
    {
        String tableAggregator = "";
        Set<Integer> keys = lookUpTable.keySet();
        for(Integer key : keys)
        {
            tableAggregator+= "\nHashKey:" + key + "\tValues:\n";
            for(Contributor contributor : lookUpTable.table[key])
            {
                tableAggregator+="\t" + contributor.toString() + "\n";
            }
        }
        return tableAggregator;
    }
}

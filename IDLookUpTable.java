package cs230individualproject;

import java.util.HashMap;
import java.util.Set;

public class IDLookUpTable {
    HashMap<String,LinkedStack<Contributor>> lookUpTable = new HashMap<String,LinkedStack<Contributor>>();
    
    //Constructor builds the lookup table
    public IDLookUpTable(LinkedStack<Contributor> contributors) {
        addTableItems(contributors);
    }
    
    //Function adds table items
    public void addTableItems(LinkedStack<Contributor> contributors)
    {
        for(Contributor contributor : contributors )
        {
        String hash = hash(contributor);
            if(lookUpTable.containsKey(hash))
            {
                lookUpTable.get(hash).push(contributor);
            }
            else
            {
                lookUpTable.put(hash, new LinkedStack<Contributor>());
                lookUpTable.get(hash).push(contributor);
            }
        }
    }
    
    //Hash function takes contributor and hashes based on entire object
    public String hash(Contributor contributor)
    {
        int charAggregate = 0;
        for(int charindex = 0; charindex < contributor.getCity().length(); charindex++)
        {
            charAggregate += contributor.getCity().charAt(charindex);
        }
        for(int charindex = 0; charindex < contributor.getName().length(); charindex++)
        {
            charAggregate += contributor.getName().charAt(charindex);
        }
        for(int charindex = 0; charindex < contributor.getCountry().length(); charindex++)
        {
            charAggregate += contributor.getCountry().charAt(charindex);
        }
        for(int charindex = 0; charindex < contributor.getPhone().length(); charindex++)
        {
            charAggregate += contributor.getPhone().charAt(charindex);
        }
        return Integer.toString((int)(contributor.getId()*3 + contributor.getContribution()*5 + charAggregate*7));
    }
    
    @Override
    public String toString()
    {
        String tableAggregator = "";
        Set<String> keys = lookUpTable.keySet();
        for(String key : keys)
        {
            tableAggregator+= "\nKey:" + key + "\tValues:\n";
            for(Contributor contributor : lookUpTable.get(key))
            {
                tableAggregator+=contributor.toString();
            }
        }
        return tableAggregator;
    }
}

package cs230individualproject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @param <ValueType>
 */
// Class StackChainedHashTable 
public class StackChainedHashTable {

    private int TABLE_SIZE;
    private int size;
    public SortLinkedStack[] table;

    // Constructor
    public StackChainedHashTable(int ts) {
        size = 0;
        TABLE_SIZE = ts;
        table = new SortLinkedStack[ts];
    }

    // Method to get number of key-value pairs 
    public int getSize() {
        return size;
    }

    // Method to clear hash table 
    public void makeEmpty() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
        size = 0;
        TABLE_SIZE = 0;
    }

    // Method to get value of a key 
    public Object get(String key) {
        int hash = (hash(key) % TABLE_SIZE);
        if (table[hash] == null) {
            return null;
        } else {
            SortLinkedStack entry = table[hash];
            Iterator entryIterator = entry.iterator();
            Object value = null;
            boolean itemFound = false;
            while (entryIterator.hasNext() && !itemFound) {
                value = entryIterator.next();
                Contributor searchContributor = new Contributor(null, null, null, null, 0, (Integer.parseInt(key)));
                itemFound = (value.equals(searchContributor));
            }
            if (!itemFound) {
                return null;
            } else {
                return value;
            }
        }
    }

    // Method to insert a key value pair 
    public void insert(String key, Comparable value) {
        int hash = (hash(key) % TABLE_SIZE);

        if (table[hash] == null) {
            table[hash] = new SortLinkedStack();
            table[hash].push(value);
            size++;
        } else {
            //Handle Collision with Hash Collision Object That is a Pointer to
            //A contributor in the linked list
            table[hash].push(value);
        }
    }

    //Remove an chain from the hash table
    public void remove(String key) {
        int hash = (hash(key) % TABLE_SIZE);
        if (table[hash] != null) {
            List arrayCopy = Arrays.asList(table);
            arrayCopy.remove(hash);
            table = (SortLinkedStack[]) arrayCopy.toArray();
        }
    }

    // Method hash which gives a hash value for a given string 
    private int hash(String x) {
        int hashVal = x.hashCode();
        hashVal %= TABLE_SIZE;
        if (hashVal < 0) {
            hashVal += TABLE_SIZE;
        }
        return hashVal;
    }

    //To string to display the hash bucket in terms of its contents with regard to its keys 
    @Override
    public String toString() {
        String tableAggregator = "";
        for (SortLinkedStack entry : table) {
            int bucketCount = 0;
            tableAggregator += ("\nBucketindex=" + bucketCount++ + "\nValue=");
            int count = 0;
            for (Object item : entry) {
                tableAggregator += "Entry:" + count++ + " " + item.toString();
            }
        }
        return "HashTable{" + "\nTABLE_SIZE=" + TABLE_SIZE + "\nSize=" + size + "\nTable=" + tableAggregator + '}';
    }

    //Return the keyset of the hash table to be used to traverse the entire data structure if need be
    Set<Integer> keySet() {
        Set<Integer> keys = new HashSet<Integer>();
        for (int keyIndex = 0; keyIndex < size; keyIndex++) {
            keys.add(keyIndex);
        }
        return keys;
    }
}

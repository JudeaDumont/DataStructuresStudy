package cs230individualproject;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author judea.dumont1
 */
/* Class StackChainedHashTable */
public class ContributorLinkedStackChainedHashTable {

    private int TABLE_SIZE;
    private int size;
    public ContributorLinkedStack[] table;

    /* Constructor */
    public ContributorLinkedStackChainedHashTable(int ts) {
        size = 0;
        TABLE_SIZE = ts;
        table = new ContributorLinkedStack[ts];
    }

    /* Method to get number of key-value pairs */
    public int getSize() {
        return size;
    }

    /* Method to clear hash table */
    public void makeEmpty() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
        size = 0;
        TABLE_SIZE = 0;
    }

    /* Method to get value of a key */
    public Contributor get(String key) {

        int hash = (hash(key) % TABLE_SIZE);

        if (table[hash] == null) {
            return null;
        } else {
            ContributorLinkedStack entry = table[hash];
            while (entry.hasNext() && !(entry.currentNode.contributor.getId() == (Integer.parseInt(key)))) {
                entry.next();
            }
            if (entry == null) {
                return null;
            } else {
                return entry.currentNode.contributor;
            }
        }
    }

    /* Method to insert a key value pair */
    public void insert(String key, Contributor contributor) {
        int hash = (hash(key) % TABLE_SIZE);

        if (table[hash] == null) {
            table[hash] = new ContributorLinkedStack();
            table[hash].push(contributor);
        } else {
            //Handle Collision
            ContributorLinkedStack entry = table[hash];

            while (entry.hasNext() && !(entry.currentNode.contributor.getId() == Integer.parseInt(key))) {
                entry.next();
            }

            if (entry.currentNode.contributor.getId() == Integer.parseInt(key)) {
                entry.currentNode.contributor = contributor;
            } else {
                entry.push(contributor);
            }
        }
        size++;
    }

    public void remove(String key) {
        int hash = (hash(key) % TABLE_SIZE);
        if (table[hash] != null) {
            ContributorLinkedStack prevEntry = null;
            ContributorLinkedStack entry = table[hash];
            while (entry.hasNext() && !(entry.currentNode.contributor.getId() == Integer.parseInt(key))) {
                prevEntry.currentNode = entry.currentNode;
                entry.next();
            }
            if (entry.currentNode.contributor.getId() == Integer.parseInt(key)) {
                if (prevEntry == null) {

                } else {
                    //Skip the entry where the ID matches the ID that was passed into remove
                    prevEntry.currentNode.next = entry.currentNode.next;
                }
                size--;
            }
        }
    }

    /* Method myhash which gives a hash value for a given string */
    private int hash(String x) {
        int hashVal = x.hashCode();
        hashVal %= TABLE_SIZE;
        if (hashVal < 0) {
            hashVal += TABLE_SIZE;
        }
        return hashVal;
    }

    /* Method to print hash table */
    public void printHashTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("\nBucket " + (i + 1) + " : ");
            ContributorLinkedStack entry = table[i];
            while (entry != null) {
                System.out.print(entry.currentNode.contributor.toString() + " ");
                entry.next();
            }
        }
    }

    @Override
    public String toString() {
        String tableAggregator = "";
        for (ContributorLinkedStack table1 : table) {
            tableAggregator += ("\nKey=" + hash(Integer.toString(table1.currentNode.contributor.getId())) + "\nValue=");
            int count = 0;
            for (Contributor contributor : table1) {
                tableAggregator += "Entry:" + count++ + " " + contributor.toString();
            }
        }
        return "HashTable{" + "\nTABLE_SIZE=" + TABLE_SIZE + "\nSize=" + size + "\nTable=" + tableAggregator + '}';
    }

    Set<Integer> keySet() {
        Set<Integer> keys = new HashSet<Integer>();
        for (ContributorLinkedStack table1 : table) {
            if (table1 != null && table1.currentNode != null && table1.currentNode.contributor != null) {
                keys.add(hash(Integer.toString(table1.currentNode.contributor.getId())));
            }
        }
        return keys;
    }
}

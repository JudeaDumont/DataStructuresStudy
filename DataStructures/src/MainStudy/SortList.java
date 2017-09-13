package cs230individualproject;

//interface to describe the abstractions of a sorted list
public interface SortList<ValueType extends Comparable> {

    void sortInsert(ValueType value);

    ValueType sequentialSearch(ValueType value);
}

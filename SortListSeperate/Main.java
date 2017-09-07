package SortListSeperate;

/**
 * Created by Owner on 9/6/2017.
 */
public class Main {
    public static void main(String... argv)
    {
        SortList<String> sortList = new SortList<>();
        sortList.insertSort("g");
        sortList.insertSort("h");
        sortList.insertSort("f");
        sortList.insertSort("e");
        sortList.insertSort("y");
        sortList.insertSort("a");
        sortList.insertSort("l");
        sortList.insertSort("h");
        sortList.insertSort("j");
        sortList.insertSort("d");
        sortList.insertSort("c");
        System.out.println(sortList.toString());
    }
}

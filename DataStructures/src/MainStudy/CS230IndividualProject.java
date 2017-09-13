package cs230individualproject;

public class CS230IndividualProject {

    //Main Represents the implementation of the test plan
    public static void main(String[] args) {
        //Get the path to contributor csv
        String pathToContributorsCSV = System.getProperty("user.dir") + "\\contributors.csv";
        //Load the contributors into a sortlinkedstack
        ContributorsFromCSV contributorLinkedStack = new ContributorsFromCSV(pathToContributorsCSV);
        //Setup lookuptable with chaining pointers into linked list
        IDAndNameLookUpTable lookUpTable = new IDAndNameLookUpTable(contributorLinkedStack.contributors);
        //Print all contributors in sortlinkedstack
        System.out.println(contributorLinkedStack.contributors.toString());
        System.out.println("*******************************************************************************************");
        //Perform searches with name and ID
        System.out.println(lookUpTable.search("George").toString());
        System.out.println(lookUpTable.search(25).toString());
    }
}

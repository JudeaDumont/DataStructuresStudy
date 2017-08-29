package cs230individualproject;

public class CS230IndividualProject {

    //Main Represents the implementation of the test plan
    public static void main(String[] args) {
        String pathToContributorsCSV = System.getProperty("user.dir") + "\\contributors.csv";
        ContributorsFromCSV contributorLinkedStack = new ContributorsFromCSV(pathToContributorsCSV);
        contributorLinkedStack.displayContributors();
        Contributor poppedContributor = contributorLinkedStack.contributors.pop();
        System.out.println("\n\n" + poppedContributor.toString() + "\n\n");
        contributorLinkedStack.displayContributors();
        IDLookUpTable idLookUpTable = new IDLookUpTable(contributorLinkedStack.contributors);
        System.out.print(idLookUpTable.toString());
    }
}

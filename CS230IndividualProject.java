package cs230individualproject;

public class CS230IndividualProject {

    public static void main(String[] args) {
              String pathToContributorsCSV = System.getProperty("user.dir") + "\\contributors.csv";
              ContributorsFromCSV contributorLinkedStack = new ContributorsFromCSV(pathToContributorsCSV);
              contributorLinkedStack.displayContributors();
              Contributor poppedContributor = contributorLinkedStack.contributors.pop();
              System.out.println("\n\n" + poppedContributor.toString() + "\n\n" );
              contributorLinkedStack.displayContributors();
    }
}

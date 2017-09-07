package MainStudy;

public class Main {

    //Main Represents the implementation of the test plan
    public static void main(String[] args) {
        String pathToContributorsCSV = System.getProperty("user.dir") + "/contributors.csv";
        ContributorsFromCSV contributorLinkedStack = new ContributorsFromCSV(pathToContributorsCSV);
        System.out.println(contributorLinkedStack.contributors.toString());
    }
}

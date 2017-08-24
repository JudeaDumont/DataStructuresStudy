package cs230individualproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

//ContributorsFromCSV is a class for parsing and marshaling plain text objects
//To java objects that can be manipulated by the system
public class ContributorsFromCSV {

    //The linkedstack the marshaled plain text objects will contain
    LinkedStack<Contributor> contributors = new LinkedStack<Contributor>();

    //Constructor Intermediary to Begin Marshalling
    public ContributorsFromCSV(String pathToContributorsCSV) {
        getContributors(pathToContributorsCSV);
    }

    //The method that parses the plain text and creates the contributor objects
    private void getContributors(String pathToContributorsCSV) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToContributorsCSV));
            String line;
            while ((line = br.readLine()) != null) {
                String[] contributorData = line.split(",");
                contributors.push(
                        new Contributor(
                                contributorData[0],
                                contributorData[1],
                                contributorData[2],
                                contributorData[3],
                                Double.parseDouble(contributorData[4]),
                                Integer.parseInt(contributorData[5])
                        ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //Simple predicate function to display the contributors that were previously parsed
    public void displayContributors() {
        Iterator contributorIterator = contributors.iterator();
        while (contributorIterator.hasNext()) {
            System.out.println(contributorIterator.next());
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cs230individualproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;
public class ContributorsFromCSV {

    LinkedStack<Contributor> contributors = new LinkedStack<Contributor>();
    public ContributorsFromCSV(String pathToContributorsCSV)
    {
        getContributors(pathToContributorsCSV);
    }

    public void getContributors(String pathToContributorsCSV) {
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
    public void displayContributors()
    {
        Iterator contributorIterator = contributors.iterator();
        while(contributorIterator.hasNext())
              {
                  System.out.println(contributorIterator.next());
              }
    }
}

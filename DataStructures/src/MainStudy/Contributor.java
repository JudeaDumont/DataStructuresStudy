package cs230individualproject;

//Contributor Class represents a contribuotr to funding a zoo
public class Contributor implements Comparable {

    private int id;
    private String name;
    private String country;
    private String city;
    private String phone;
    private double contribution;

    //Only the parameterized constructor is necessary in these instances
    public Contributor(String name, String city, String Coutry, String phone, double contribution, int id) {
        this.id = id;
        this.name = name;
        this.country = Coutry;
        this.city = city;
        this.phone = phone;
        this.contribution = contribution;
    }

    //Override the toString method to make displaying a contributors information easier
    @Override
    public String toString() {
        return "Name: " + name + "\t" + "City: " + city + "\t" + "Country: " + country + "\t" + "Phone: " + phone + "\t" + "Contribution: "
                + contribution + "\t" + "ID: " + id + "\t";
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public double getContribution() {
        return contribution;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setContribution(double contribution) {
        this.contribution = contribution;
    }

    //Overriding for the point of conforming to the generic implementation for
    //the rest of the datastructures and overarching data structures therein. 
    @Override
    public int compareTo(Object someContributor) {
        return this.name.trim().compareTo(((Contributor) someContributor).name.trim());
    }

    @Override
    public boolean equals(Object o) {
        return (this.getId() == ((Contributor) o).getId());
    }
}

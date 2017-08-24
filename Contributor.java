package cs230individualproject;

//Contributor Class represents a contribuotr to funding a zoo
public class Contributor {

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
        return name + "\t" + city + "\t" + country + "\t" + phone + "\t" + contribution + "\t" + id + "\t";
    }
}

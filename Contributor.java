package cs230individualproject;

public class Contributor {

    private int id;
    private String name;
    private String country;
    private String city;
    private String phone;
    private double contribution;

    public Contributor(String name, String city, String Coutry, String phone, double contribution, int id) {
        this.id = id;
        this.name = name;
        this.country = Coutry;
        this.city = city;
        this.phone = phone;
        this.contribution = contribution;
    }

    @Override
    public String toString()
    {
        return name + "\t" + city + "\t" + country + "\t" + phone + "\t" + contribution + "\t" + id + "\t";
    }
}

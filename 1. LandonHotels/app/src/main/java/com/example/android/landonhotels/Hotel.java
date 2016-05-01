package com.example.android.landonhotels;

public class Hotel {

    private String city;
    private String neighborhood;
    private String description;
    private String image;
    private String address;

    public Hotel(String city,
                 String neighborhood,
                 String description,
                 String image,
                 String address) {
        this.city = city;
        this.neighborhood = neighborhood;
        this.description = description;
        this.image = image;
        this.address = address;
    }

    public String getCity() {
        return city;
    }
    public String getNeighborhood() {
        return neighborhood;
    }
    public String getDescription() {
        return description;
    }
    public String getImage() {
        return image;
    }
    public String getAddress() {
        return address;
    }

}

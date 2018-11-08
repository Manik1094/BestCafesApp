package com.example.manikgupta.bestcafes;



public class CustomCafes {

    private String name;
    private String location;
    private String description;
    private String cost;
    private String image;


    public CustomCafes(String name , String location , String description, String cost ,String image){
        this.name = name;
        this.location = location;
        this.description = description;
        this.cost  = cost;
        this.image  = image;

    }
    public CustomCafes(){
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String getCost() {
        return cost;
    }


}

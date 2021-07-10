package com.example.eventsjson.Models;

public class eventsmodel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    String name, image, date, place,fee;
    public eventsmodel(){

    }
    public eventsmodel(String name,String image, String date, String place, String fee){
        this.date=date;
        this.fee=fee;
        this.image=image;
        this.name=name;
        this.place=place;
        this.image=image;
    }
}

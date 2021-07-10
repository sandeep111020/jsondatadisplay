package com.example.eventsjson.Models;

public class placesmodel {
    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    private String book_title;
    private String image;
    private String author;

    public placesmodel(){

    }
    public placesmodel(String book_title, String image) {
      this.image=image;
      this.book_title=book_title;
    }


}
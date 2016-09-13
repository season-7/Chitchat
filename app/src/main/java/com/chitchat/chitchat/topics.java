package com.chitchat.chitchat;

/**
 * Created by EduhG on 9/13/2016.
 */
public class Topics {
    String name;
    String questions;
    String imageUrl;

    // empty constructor needed by the Parceler library:
    public Topics() {}

    public Topics(String name, String questions, String imageUrl) {
        this.name = name;
        this.questions = questions;
        this.imageUrl = getLargeImageUrl(imageUrl);
    }

    public String getName() {
        return name;
    }

    public String getQuestions() {
        return questions;
    }

    public String getImageUrl(){
        return imageUrl;
    }

    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }
}
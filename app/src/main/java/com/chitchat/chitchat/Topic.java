package com.chitchat.chitchat;

/**
 * Created by mitchelle on 9/17/16.
 */
public class Topic {
    String author;
    String message;
    String uid;

    // empty constructor needed by the Parceler library:
    public Topic() {}

    public Topic(String name, String questions, String imageUrl) {
        this.author = name;
        this.message = questions;
        this.uid = getLargeImageUrl(imageUrl);
    }

    public String getName() {
        return author;
    }

    public String getQuestions() {
        return message;
    }

    public String getImageUrl(){
        return uid;
    }

    public String getLargeImageUrl(String imageUrl) {
        String largeImageUrl = imageUrl.substring(0, imageUrl.length() - 6).concat("o.jpg");
        return largeImageUrl;
    }
}
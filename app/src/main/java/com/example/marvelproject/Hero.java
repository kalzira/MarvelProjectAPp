package com.example.marvelproject;

public class Hero {

    // Hero items
    private String mTitle;
    private String mIntro;
    private int mPhotoId;

    public Hero(String mTitle,
                String mIntro,
                int mPhotoId){
        this.mTitle = mTitle;
        this.mIntro = mIntro;
        this.mPhotoId = mPhotoId;
    }

    //These are your GETTERS to return the selected items
    public String getVenueTitle() {
        return mTitle;
    }
    public String getVenueIntro() {
        return mIntro;
    }
    public int getVenuePhotoId() {
        return mPhotoId;
    }
}
package com.example.photogallery;

public class imagesArrayList {
    String imageID;
    String description;

    public imagesArrayList(String imageID, String description) {
        this.imageID = imageID;
        this.description = description;
    }
    //public imagesArrayList(){}

    public String getImageID() {
        return imageID;
    }

    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

package com.example.user.sixthsense;

/**
 * Created by User on 23/9/2016.
 */

public class NFCKeys {
    private String image;
    private String Information;
    private String Name;
    private String Category;

    public NFCKeys(String information, String image, String name, String category) {
        Information = information;
        this.image = image;
        Name = name;
        Category = category;
        System.out.println("this is the image "+ this.image);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInformation() {
        return Information;
    }

    public void setInformation(String information) {
        Information = information;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }
}

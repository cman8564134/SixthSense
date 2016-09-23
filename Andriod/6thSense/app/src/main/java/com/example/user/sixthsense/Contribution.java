package com.example.user.sixthsense;

/**
 * Created by User on 23/9/2016.
 */

public class Contribution {

    private String Bark;
    private String Legs;
    private boolean Meow;

    public boolean getMeow() {
        return Meow;
    }

    public void setMeow(String meow) {
        if(meow=="Yes")
        Meow = true;
        else
            Meow=false;
    }

    public String getLegs() {
        return Legs;
    }

    public void setLegs(String legs) {
        Legs = legs;
    }

    public String getBark() {
        return Bark;
    }

    public void setBark(String bark) {
        Bark = bark;
    }
}

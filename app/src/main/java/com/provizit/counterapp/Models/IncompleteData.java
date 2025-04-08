package com.provizit.counterapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class IncompleteData implements Serializable {

    private ArrayList<String> pic;


    public ArrayList<String> getPic() {
        return pic;
    }

    public void setPic(ArrayList<String> pic) {
        this.pic = pic;
    }
}
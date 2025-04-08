package com.provizit.counterapp.Models;

import java.io.Serializable;

public class UserDetails implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

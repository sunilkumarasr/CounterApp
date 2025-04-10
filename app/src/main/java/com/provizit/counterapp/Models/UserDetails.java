package com.provizit.counterapp.Models;

import java.io.Serializable;

public class UserDetails implements Serializable {

    CommonObject _id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public CommonObject get_id() {
        return _id;
    }

    public void set_id(CommonObject _id) {
        this._id = _id;
    }
}

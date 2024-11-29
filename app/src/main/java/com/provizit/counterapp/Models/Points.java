package com.provizit.counterapp.Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Points implements Serializable {
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public JSONObject getPoints(){
        JSONObject jo = new JSONObject();
        try {
            jo.put("desc", this.desc);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }
}

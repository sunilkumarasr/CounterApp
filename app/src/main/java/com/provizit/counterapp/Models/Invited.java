package com.provizit.counterapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Invited implements Serializable {
    private String name;
    private String mobile;
    private String email;
    private String company;
    private String id="";
    private String link;
    private boolean covisitor = false;
    private boolean assign = false;
    ArrayList<String> pic;
    private int status = 0;
    private int verify = 0;


    public ArrayList<String> getPic() {
        return pic;
    }

    public void setPic(ArrayList<String> pic) {
        this.pic = pic;
    }

    public boolean isAssign() {
        return assign;
    }

    public void setAssign(boolean assign) {
        this.assign = assign;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getVerify() {
        return verify;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

    public boolean isCovisitor() {
        return covisitor;
    }

    public void setCovisitor(boolean covisitor) {
        this.covisitor = covisitor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public JSONObject getInvites(){
        JSONObject jo = new JSONObject();
        try {
            jo.put("name", this.name);
            jo.put("mobile", this.mobile);
            jo.put("company", this.company);
            jo.put("id", this.id);
            jo.put("email", this.email);
            jo.put("covisitor", this.covisitor);
            jo.put("link", this.link);
            jo.put("status", this.status);
            jo.put("verify", this.verify);
            jo.put("assign", this.assign);
            jo.put("reschedule", new JSONArray());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }

}


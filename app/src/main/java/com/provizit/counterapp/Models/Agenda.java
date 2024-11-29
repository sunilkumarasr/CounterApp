package com.provizit.counterapp.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable {

    private String desc;
    private String supertype;
    private String emp_id;
    private String mid;
    private String status;
    CommonObject _id;
    CommonObject created_time;

    public void setCreated_time(CommonObject created_time) {
        this.created_time = created_time;
    }

    private ArrayList<Points> points;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ArrayList<Points> getPoints() {
        return points;
    }

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CommonObject get_id() {
        return _id;
    }

    public void set_id(CommonObject _id) {
        this._id = _id;
    }

    public void setPoints(ArrayList<Points> points) {
        this.points = points;
    }

    public JSONObject getAgenda(){
        JSONObject jo = new JSONObject();
        JSONArray pointsArray = new JSONArray();
        try {
            pointsArray = new JSONArray();
            for (int i = 0; i < points.size(); i++) {
                pointsArray.put(points.get(i).getPoints());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jo.put("desc", this.desc);
            if(_id != null){
                jo.put("_id", _id.get_id());
            }
            if(created_time != null){
                jo.put("created_time", created_time.getCreated_time());
            }
            jo.put("points", pointsArray);
            jo.put("supertype", this.supertype);
            jo.put("emp_id", this.emp_id);
            jo.put("mid", this.mid);
            jo.put("status", this.status);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }
}
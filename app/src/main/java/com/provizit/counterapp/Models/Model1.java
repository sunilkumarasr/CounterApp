package com.provizit.counterapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class Model1 implements Serializable {
    public Integer result;
    public ArrayList<CompanyData> items;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public ArrayList<CompanyData> getItems() {
        return items;
    }

    public void setItems(ArrayList<CompanyData> items) {
        this.items = items;
    }
}

package com.provizit.counterapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class OutlookModel implements Serializable {
    public Integer result;
    public ArrayList<OutlookItems> items;
    public IncompleteData incomplete_data;

    public IncompleteData getIncomplete_data() {
        return incomplete_data;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public ArrayList<OutlookItems> getItems() {
        return items;
    }

    public void setItems(ArrayList<OutlookItems> items) {
        this.items = items;
    }
}

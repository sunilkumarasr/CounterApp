package com.provizit.counterapp.Models;

import java.io.Serializable;

public class Model implements Serializable {
    public Integer result;
    public CompanyData items;

    IncompleteData incomplete_data;

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public CompanyData getItems() {
        return items;
    }

    public void setItems(CompanyData items) {
        this.items = items;
    }

    public IncompleteData getIncomplete_data() {
        return incomplete_data;
    }

    public void setIncomplete_data(IncompleteData incomplete_data) {
        this.incomplete_data = incomplete_data;
    }
}

package com.provizit.counterapp.Models;

import java.io.Serializable;

public class CategoryData implements Serializable {
    private Boolean cat_type;

    public Boolean getCat_type() {
        return cat_type;
    }

    public void setCat_type(Boolean cat_type) {
        this.cat_type = cat_type;
    }
}

package com.provizit.counterapp.Models;

import java.io.Serializable;

public class AutoShutDownModel implements Serializable {
    public String name;
    public String status;
    public String start;
    public String end;

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}

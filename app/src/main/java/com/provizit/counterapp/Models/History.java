package com.provizit.counterapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class History implements Serializable {
    private CommonObject request;
    private Long checkin ;
    private Long hstatus ;
    private Long rstatus ;
    private Long status ;
    private String purpose;
    private String host;

    public String getBadge() {
        return badge;
    }

    public void setRequest(CommonObject request) {
        this.request = request;
    }

    public void setCheckin(Long checkin) {
        this.checkin = checkin;
    }

    public void setHstatus(Long hstatus) {
        this.hstatus = hstatus;
    }

    public void setRstatus(Long rstatus) {
        this.rstatus = rstatus;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public void setLivepic(ArrayList<String> livepic) {
        this.livepic = livepic;
    }

    private String badge;
    private ArrayList<String> livepic;

    public Long getStatus() {
        return status;
    }

    public String getHost() {
        return host;
    }

    public Long getCheckin() {
        return checkin;
    }

    public Long getHstatus() {
        return hstatus;
    }

    public Long getRstatus() {
        return rstatus;
    }

    public CommonObject getRequest() {
        return request;
    }

    public String getPurpose() {
        return purpose;
    }

    public ArrayList<String> getLivepic() {
        return livepic;
    }

}

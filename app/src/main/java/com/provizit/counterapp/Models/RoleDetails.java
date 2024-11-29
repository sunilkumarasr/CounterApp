package com.provizit.counterapp.Models;

import java.io.Serializable;

public class RoleDetails implements Serializable {
    private String r_id;
    private String name;
    private String desc;
    private String location;
    private String hierarchy;
    private String approver;
    private String meeting;
    private String reports;
    private String smeeting;
    private String visitors;
    private String dvisitors;
    private String operations;
    private String rmeeting;
    private String uvisitors;
    private String bydefault;
    private String checkin;
    private String aworkflow;
    private String security;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getR_id() {
        return r_id;
    }

    public void setR_id(String r_id) {
        this.r_id = r_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getMeeting() {
        return meeting;
    }

    public void setMeeting(String meeting) {
        this.meeting = meeting;
    }

    public String getReports() {
        return reports;
    }

    public void setReports(String reports) {
        this.reports = reports;
    }

    public String getSmeeting() {
        return smeeting;
    }

    public void setSmeeting(String smeeting) {
        this.smeeting = smeeting;
    }

    public String getVisitors() {
        return visitors;
    }

    public void setVisitors(String visitors) {
        this.visitors = visitors;
    }

    public String getDvisitors() {
        return dvisitors;
    }

    public void setDvisitors(String dvisitors) {
        this.dvisitors = dvisitors;
    }

    public String getOperations() {
        return operations;
    }

    public void setOperations(String operations) {
        this.operations = operations;
    }

    public String getRmeeting() {
        return rmeeting;
    }

    public void setRmeeting(String rmeeting) {
        this.rmeeting = rmeeting;
    }

    public String getUvisitors() {
        return uvisitors;
    }

    public void setUvisitors(String uvisitors) {
        this.uvisitors = uvisitors;
    }

    public String getBydefault() {
        return bydefault;
    }

    public void setBydefault(String bydefault) {
        this.bydefault = bydefault;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getAworkflow() {
        return aworkflow;
    }

    public void setAworkflow(String aworkflow) {
        this.aworkflow = aworkflow;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }
}

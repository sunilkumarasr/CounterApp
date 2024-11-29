package com.provizit.counterapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class EmpData implements Serializable {

    private String name;
    private String designation;
    private String email;
    private String mobile;
    private String mobilecode;
    private String roleid;
    private String rolename;
    private String location;
    private String hierarchy_indexid;
    private String hierarchy_id;
    private String approver;
    private String emp_id;
    private String emp_image1;
    private ArrayList<String> pic;

    public String getEmp_image1() {
        return emp_image1;
    }

    public void setEmp_image1(String emp_image1) {
        this.emp_image1 = emp_image1;
    }

    public ArrayList<String> getPic() {
        return pic;
    }

    public void setPic(ArrayList<String> pic) {
        this.pic = pic;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobilecode() {
        return mobilecode;
    }

    public void setMobilecode(String mobilecode) {
        this.mobilecode = mobilecode;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHierarchy_indexid() {
        return hierarchy_indexid;
    }

    public void setHierarchy_indexid(String hierarchy_indexid) {
        this.hierarchy_indexid = hierarchy_indexid;
    }

    public String getHierarchy_id() {
        return hierarchy_id;
    }

    public void setHierarchy_id(String hierarchy_id) {
        this.hierarchy_id = hierarchy_id;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }
}

package com.provizit.counterapp.Models;

import java.io.Serializable;
import java.util.ArrayList;

public class CompanyData implements Serializable {
    private RoleDetails roleDetails;
    CommonObject hierarchys;
    UserDetails userDetails;
    private EmpData empData;

    private AutoShutDownModel today;

    private AutoShutDownModel nextday;
    private String emp_id;
    private String email;
    private String mobile;
    private String mobilecode;
    private String entrypoint;
    private String meetingroom;
    private String comp_id;
    private String location;
    private String name;
    private String company;
    private String desc;
    private String supertype;
    private String floor;
    private String hierarchy_indexid;
    private String hierarchy_id;
    private String capacity;
    private String pointer;
    private String subject;
    private String approver_roleid;
    ArrayList<Invited> invites;
    EmpData employee;
    EmpData host;
    Room room;
    Room entry;
    private String e_time;
    private Boolean projector;
    private Boolean screen;
    private Boolean internet;
    private Boolean telephone;
    private Boolean speaker;
    private Boolean active;
    private Boolean trd_access;
    private CommonObject _id;
    private ArrayList<LocationData> address;
    private long date;
    private long start;
    private long end;
    private ArrayList<String> pic;
    private String e_pic;
    private String role;
    private String link;
    private String rm_email;
    private String designation;
    private String token_no;
    private CommonObject meetingrooms;
    private ArrayList<History> history;
    private CommonObject entrypoints;
    private CommonObject locations;
    private CommonObject rand_id;
    private ArrayList<Agenda> agenda;
    private CategoryData categoryData;

    public Boolean getTrd_access() {
        return trd_access;
    }

    public CategoryData getCategoryData() {
        return categoryData;
    }

    public void setCategoryData(CategoryData categoryData) {
        this.categoryData = categoryData;
    }

    public String getRm_email() {
        return rm_email;
    }

    public void setHierarchys(CommonObject hierarchys) {
        this.hierarchys = hierarchys;
    }

    public void setHierarchy_indexid(String hierarchy_indexid) {
        this.hierarchy_indexid = hierarchy_indexid;
    }

    public void setHierarchy_id(String hierarchy_id) {
        this.hierarchy_id = hierarchy_id;
    }

    public void setHost(EmpData host) {
        this.host = host;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setMeetingrooms(CommonObject meetingrooms) {
        this.meetingrooms = meetingrooms;
    }

    public void setHistory(ArrayList<History> history) {
        this.history = history;
    }

    public void setEntrypoints(CommonObject entrypoints) {
        this.entrypoints = entrypoints;
    }

    public void setLocations(CommonObject locations) {
        this.locations = locations;
    }

    public void setRand_id(CommonObject rand_id) {
        this.rand_id = rand_id;
    }

    public void setVerify(int verify) {
        this.verify = verify;
    }

    public void setMverify(int mverify) {
        this.mverify = mverify;
    }

    public String getRole() {
        return role;
    }

    private int samecabin;
    private int verify;
    int status;
    int mverify;

    public EmpData getHost() {
        return host;
    }

    public int getMverify() {
        return mverify;
    }

    public int getVerify() {
        return verify;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public CommonObject getHierarchys() {
        return hierarchys;
    }

    public String getHierarchy_indexid() {
        return hierarchy_indexid;
    }

    public String getHierarchy_id() {
        return hierarchy_id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getToken_no() {
        return token_no;
    }

    public void setToken_no(String token_no) {
        this.token_no = token_no;
    }

    public ArrayList<History> getHistory() {
        return history;
    }

    public CommonObject getRand_id() {
        return rand_id;
    }

    public ArrayList<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList<Agenda> agenda) {
        this.agenda = agenda;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSamecabin() {
        return samecabin;
    }

    public void setSamecabin(int samecabin) {
        this.samecabin = samecabin;
    }

    public String getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(String entrypoint) {
        this.entrypoint = entrypoint;
    }

    public String getMeetingroom() {
        return meetingroom;
    }

    public void setMeetingroom(String meetingroom) {
        this.meetingroom = meetingroom;
    }

    public CommonObject getMeetingrooms() {
        return meetingrooms;
    }

    public CommonObject getEntrypoints() {
        return entrypoints;
    }

    public CommonObject getLocations() {
        return locations;
    }

    public String getE_pic() {
        return e_pic;
    }

    public void setE_pic(String e_pic) {
        this.e_pic = e_pic;
    }

    public ArrayList<String> getPic() {
        return pic;
    }

    public void setPic(ArrayList<String> pic) {
        this.pic = pic;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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



    public long getDate() {
        return date;
    }

    public String getApprover_roleid() {
        return approver_roleid;
    }

    public void setApprover_roleid(String approver_roleid) {
        this.approver_roleid = approver_roleid;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public ArrayList<Invited> getInvites() {
        return invites;
    }

    public void setInvites(ArrayList<Invited> invites) {
        this.invites = invites;
    }

    public EmpData getEmployee() {
        return employee;
    }

    public void setEmployee(EmpData employee) {
        this.employee = employee;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getEntry() {
        return entry;
    }

    public void setEntry(Room entry) {
        this.entry = entry;
    }

    public String getE_time() {
        return e_time;
    }

    public void setE_time(String e_time) {
        this.e_time = e_time;
    }



    public ArrayList<LocationData> getAddress() {
        return address;
    }

    public void setAddress(ArrayList<LocationData> address) {
        this.address = address;
    }

    public CommonObject get_id() {
        return _id;
    }

    public void set_id(CommonObject _id) {
        this._id = _id;
    }

    public RoleDetails getRoleDetails() {
        return roleDetails;
    }

    public void setRoleDetails(RoleDetails roleDetails) {
        this.roleDetails = roleDetails;
    }

    public String getComp_id() {
        return comp_id;
    }

    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

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

    public String getSupertype() {
        return supertype;
    }

    public void setSupertype(String supertype) {
        this.supertype = supertype;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public Boolean getProjector() {
        return projector;
    }

    public void setProjector(Boolean projector) {
        this.projector = projector;
    }

    public Boolean getScreen() {
        return screen;
    }

    public void setScreen(Boolean screen) {
        this.screen = screen;
    }

    public Boolean getInternet() {
        return internet;
    }

    public void setInternet(Boolean internet) {
        this.internet = internet;
    }

    public Boolean getTelephone() {
        return telephone;
    }

    public void setTelephone(Boolean telephone) {
        this.telephone = telephone;
    }

    public Boolean getSpeaker() {
        return speaker;
    }

    public void setSpeaker(Boolean speaker) {
        this.speaker = speaker;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }



    public EmpData getEmpData() {
        return empData;
    }

    public void setEmpData(EmpData empData) {
        this.empData = empData;
    }

    public AutoShutDownModel getToday() {
        return today;
    }

    public AutoShutDownModel getNextday() {
        return nextday;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
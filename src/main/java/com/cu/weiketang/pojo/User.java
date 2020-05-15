package com.cu.weiketang.pojo;

public class User {
    private Integer uid;

    private String unumber;

    private String upassword;

    private String ucollage;

    private String uname;

    private Integer type;

    public User(Integer uid, String unumber, String upassword, String ucollage, String uname, Integer type) {
        this.uid = uid;
        this.unumber = unumber;
        this.upassword = upassword;
        this.ucollage = ucollage;
        this.uname = uname;
        this.type = type;
    }

    public User() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUnumber() {
        return unumber;
    }

    public void setUnumber(String unumber) {
        this.unumber = unumber == null ? null : unumber.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getUcollage() {
        return ucollage;
    }

    public void setUcollage(String ucollage) {
        this.ucollage = ucollage == null ? null : ucollage.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
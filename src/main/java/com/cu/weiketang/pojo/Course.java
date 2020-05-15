package com.cu.weiketang.pojo;

import java.util.Date;

public class Course {
    private Integer cid;

    private String cname;

    private String cpicture;

    private String cintroduce;

    private String cgrade;

    private Integer crequirements;

    private String cnumber;

    private Integer uid;

    private Date updateTime;

    private Boolean state;

    public Course(Integer cid, String cname, String cpicture, String cintroduce, String cgrade, Integer crequirements, String cnumber, Integer uid, Date updateTime, Boolean state) {
        this.cid = cid;
        this.cname = cname;
        this.cpicture = cpicture;
        this.cintroduce = cintroduce;
        this.cgrade = cgrade;
        this.crequirements = crequirements;
        this.cnumber = cnumber;
        this.uid = uid;
        this.updateTime = updateTime;
        this.state = state;
    }

    public Course() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCpicture() {
        return cpicture;
    }

    public void setCpicture(String cpicture) {
        this.cpicture = cpicture == null ? null : cpicture.trim();
    }

    public String getCintroduce() {
        return cintroduce;
    }

    public void setCintroduce(String cintroduce) {
        this.cintroduce = cintroduce == null ? null : cintroduce.trim();
    }

    public String getCgrade() {
        return cgrade;
    }

    public void setCgrade(String cgrade) {
        this.cgrade = cgrade == null ? null : cgrade.trim();
    }

    public Integer getCrequirements() {
        return crequirements;
    }

    public void setCrequirements(Integer crequirements) {
        this.crequirements = crequirements;
    }

    public String getCnumber() {
        return cnumber;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber == null ? null : cnumber.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
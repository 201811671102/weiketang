package com.cu.weiketang.pojo;

public class Discussion {
    private Integer did;

    private Integer uid;

    private String ucollage;

    private String uname;

    private String dcontent;

    private Integer lid;

    public Discussion(Integer did, Integer uid, String ucollage, String uname, String dcontent, Integer lid) {
        this.did = did;
        this.uid = uid;
        this.ucollage = ucollage;
        this.uname = uname;
        this.dcontent = dcontent;
        this.lid = lid;
    }

    public Discussion() {
        super();
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
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

    public String getDcontent() {
        return dcontent;
    }

    public void setDcontent(String dcontent) {
        this.dcontent = dcontent == null ? null : dcontent.trim();
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }
}
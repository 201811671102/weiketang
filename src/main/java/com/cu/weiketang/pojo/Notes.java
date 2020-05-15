package com.cu.weiketang.pojo;

public class Notes {
    private Integer nid;

    private Integer uid;

    private String ucontent;

    public Notes(Integer nid, Integer uid, String ucontent) {
        this.nid = nid;
        this.uid = uid;
        this.ucontent = ucontent;
    }

    public Notes() {
        super();
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUcontent() {
        return ucontent;
    }

    public void setUcontent(String ucontent) {
        this.ucontent = ucontent == null ? null : ucontent.trim();
    }
}
package com.cu.weiketang.pojo;

import java.util.Date;

public class Record {
    private Integer rid;

    private Integer uid;

    private Integer cid;

    private Integer lid;

    private Date rtime;

    private Integer lnumber;

    private Date utime;

    public Record(Integer rid, Integer uid, Integer cid, Integer lid, Date rtime, Integer lnumber, Date utime) {
        this.rid = rid;
        this.uid = uid;
        this.cid = cid;
        this.lid = lid;
        this.rtime = rtime;
        this.lnumber = lnumber;
        this.utime = utime;
    }

    public Record() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Date getRtime() {
        return rtime;
    }

    public void setRtime(Date rtime) {
        this.rtime = rtime;
    }

    public Integer getLnumber() {
        return lnumber;
    }

    public void setLnumber(Integer lnumber) {
        this.lnumber = lnumber;
    }

    public Date getUtime() {
        return utime;
    }

    public void setUtime(Date utime) {
        this.utime = utime;
    }
}
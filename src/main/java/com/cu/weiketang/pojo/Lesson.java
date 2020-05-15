package com.cu.weiketang.pojo;

public class Lesson {
    private Integer lid;

    private String lname;

    private String lvideo;

    private Integer chapterId;

    private String chapterName;

    private Integer cid;

    public Lesson(Integer lid, String lname, String lvideo, Integer chapterId, String chapterName, Integer cid) {
        this.lid = lid;
        this.lname = lname;
        this.lvideo = lvideo;
        this.chapterId = chapterId;
        this.chapterName = chapterName;
        this.cid = cid;
    }

    public Lesson() {
        super();
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getLvideo() {
        return lvideo;
    }

    public void setLvideo(String lvideo) {
        this.lvideo = lvideo == null ? null : lvideo.trim();
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName == null ? null : chapterName.trim();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
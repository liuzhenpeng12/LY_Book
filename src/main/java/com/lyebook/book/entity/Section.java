package com.lyebook.book.entity;

import java.sql.Date;

public class Section {
    private Integer sid;
    private Integer bid;
    private String sname;
    private String surl;
    private Date createtime;

    public Section() {
        super();
    }

    @Override
    public String toString() {
        return "Section{" +
                "sid=" + sid +
                ", bid=" + bid +
                ", sname='" + sname + '\'' +
                ", surl='" + surl + '\'' +
                ", createtime=" + createtime +
                '}';
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSurl() {
        return surl;
    }

    public void setSurl(String surl) {
        this.surl = surl;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Section(Integer sid, Integer bid, String sname, String surl, Date createtime) {
        this.sid = sid;
        this.bid = bid;
        this.sname = sname;
        this.surl = surl;
        this.createtime = createtime;
    }
}

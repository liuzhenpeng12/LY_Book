package com.lyebook.book.entity;

import java.sql.Date;

public class Article {
    private Integer cid;
    private Integer sid;
    private String concent;
    private Date time;

    public Article() {
        super();
    }

    @Override
    public String toString() {
        return "Article{" +
                "cid=" + cid +
                ", sid=" + sid +
                ", concent='" + concent + '\'' +
                ", time=" + time +
                '}';
    }

    public Article(Integer cid, Integer sid, String concent, Date time) {
        this.cid = cid;
        this.sid = sid;
        this.concent = concent;
        this.time = time;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getConcent() {
        return concent;
    }

    public void setConcent(String concent) {
        this.concent = concent;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}

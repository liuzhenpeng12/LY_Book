package com.lyebook.book.entity;

public class Img {
    private String imgurl;
    private String imgname;

    public Img() {
        super();
    }

    @Override
    public String toString() {
        return "Img{" +
                "imgurl='" + imgurl + '\'' +
                ", imgname='" + imgname + '\'' +
                '}';
    }

    public Img(String imgurl, String imgname) {
        this.imgurl = imgurl;
        this.imgname = imgname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname;
    }
}

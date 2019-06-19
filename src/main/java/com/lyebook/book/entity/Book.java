package com.lyebook.book.entity;

import java.sql.Timestamp;

public class Book {
    private Integer id;
    private String bookname;
    private String bookinto;
    private String author;
    private String imgpath;
    private String bookurl;
    private Timestamp date;

    public Book() {
        super();
    }
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", bookinto='" + bookinto + '\'' +
                ", author='" + author + '\'' +
                ", imgpath='" + imgpath + '\'' +
                ", bookurl='" + bookurl + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getBookinto() {
        return bookinto;
    }

    public void setBookinto(String bookinto) {
        this.bookinto = bookinto;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImgpath() {
        return imgpath;
    }

    public void setImgpath(String imgpath) {
        this.imgpath = imgpath;
    }

    public String getBookurl() {
        return bookurl;
    }

    public void setBookurl(String bookurl) {
        this.bookurl = bookurl;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Book(Integer id, String bookname, String bookinto, String author, String imgpath, String bookurl, Timestamp date) {
        this.id = id;
        this.bookname = bookname;
        this.bookinto = bookinto;
        this.author = author;
        this.imgpath = imgpath;
        this.bookurl = bookurl;
        this.date = date;
    }
}

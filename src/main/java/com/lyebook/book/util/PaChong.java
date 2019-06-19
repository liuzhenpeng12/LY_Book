package com.lyebook.book.util;

import com.lyebook.book.entity.Book;
import com.lyebook.book.entity.Img;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaChong {
    /**
     * 获取小说各章节内容
     * @param url
     * @return
     */
    public String paChong(String url) {

        return GetDocument(url).getElementById("content").toString();
    }

    /**
     * 获取所有小说链接
     * @return
     */
    public List<String> paChong2(){
        HttpResponse response = HttpRequest.get("http://www.xbiquge.la/xiaoshuodaquan/").execute();
        Document document = Jsoup.parse(response.toString());

        Element element = document.getElementById("main");
        //System.out.println(element);
        Elements elements = element.getElementsByTag("a");
        //System.out.println(elements);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            list.add(elements.get(i).attr("href"));
            System.out.println("qunbu"+elements.get(i).attr("href"));
        }
        return list;
    }

    /**
     * 获取主页面的所有小说名（已弃用）
     * @return
     */
    public List<String> getbook2(){
        HttpResponse response = HttpRequest.get("http://www.xbiquge.la/xiaoshuodaquan/").execute();
        Document document = Jsoup.parse(response.toString());
        Element element = document.getElementById("main");
        Elements elements = element.getElementsByTag("a");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            list.add(elements.get(i).text());
        }
        return list;
    }

    /**
     * 获取链接document对象
     * @param url
     * @return
     */
    private Document GetDocument(String url){
        //System.out.println(url);
        HttpResponse response = HttpRequest.get(url).execute();
        Document document = Jsoup.parse(response.toString());
        return document;
    }

    /**
     * 获取指定书的章节名
     * @param url
     * @return
     */
    public List<String> Section(String url){
        Elements elements = GetDocument(url).getElementById("list").getElementsByTag("a");
        List<String> list  = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++){
            String name = elements.get(i).text();
            list.add(name);
        }
        return list;
    }
    /**
     * 获取小说各章节链接
     * @param url
     * @return
     */
    public List<String> Chapter(String url){
       Element element =  GetDocument(url).getElementById("list");
       Elements elements = element.getElementsByTag("a");
       List<String> list  = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            String str = "http://www.xbiquge.la"+elements.get(i).attr("href");
            list.add(str);
        }
        return list;
    }

    /**
     * 获取章节名称
     * @param url
     * @return
     */
    public List<String> ChapterName(String url){
        Element element =  GetDocument(url).getElementById("list");
        Elements elements = element.getElementsByTag("a");
        List<String> list  = new ArrayList<>();
        for (int i = 0; i < elements.size(); i++) {
            String str = elements.get(i).text();
            list.add(str);
        }
        return list;
    }
    /**
     * 更改小说图片路径
     * @param url
     * @return
     */
    public String getimgpath(String url){
        Img img = getimg(url);
        String imgurl = "img/"+img.getImgname();
        System.out.println(".imgurl="+imgurl);
        return imgurl;
    }
    /**
     * 获取书名+图片路径+简介+作者+章节路径
     * @param url
     * @return
     */
    public Book getbook(String url){
        Book book = new Book();
        List<Book> books = new ArrayList<>();
        String bookname = GetDocument(url).getElementById("info").getElementsByTag("h1").text();
        Elements elements = GetDocument(url).getElementById("info").getElementsByTag("p");
        String author = elements.get(0).text();
        String bookinto = GetDocument(url).getElementById("intro").getElementsByTag("p").get(1).text();
        Img img = getimg(url);
            String imgurl = "img/"+img.getImgname();
            book.setBookname(bookname);
            book.setAuthor(author);
            book.setBookinto(bookinto);
            book.setImgpath(imgurl);
            book.setBookurl(url);
        return book;
    }

    /**
     * 获取图片地址+图片名
     * @param url
     * @return
     */
    public Img getimg(String url){
        String img = GetDocument(url).getElementById("fmimg").getElementsByTag("img").attr("src");
        String imgname = img.substring(42);
        Pattern pattern = Pattern.compile("/.*/");
        Pattern pattern1 = Pattern.compile("(?<=\\/).*(?=\\/)");
        Matcher matcher = pattern.matcher(imgname);
        Img imgs = new Img();
        while (matcher.find()){
            Matcher matcher1 = pattern1.matcher(matcher.group());
            while (matcher1.find()){
                String imgnames = matcher1.group()+"s.jpg";
                imgs.setImgname(imgnames);
                imgs.setImgurl(img);
            }

        }
        return imgs;
    }
}


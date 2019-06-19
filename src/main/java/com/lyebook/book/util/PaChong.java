package com.lyebook.book.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫类
 * 可以爬取网站上小说的数据
 * 小说网址是：http://www.xbiquge.la/xiaoshuodaquan/
 */
public class PaChong {
    /**
     * 获取所有小说名称
     * @return
     */
    public void getBookName(){
        HttpResponse response = HttpRequest.get("http://www.xbiquge.la/xiaoshuodaquan/").execute();
        Document document = Jsoup.parse(response.toString());
        //获取mian标签的内容
        Element element = document.getElementById("main");
        Elements elements = element.getElementsByTag("a");
        for(Element str:elements){
            System.out.println(str.text());
        }
    }
}

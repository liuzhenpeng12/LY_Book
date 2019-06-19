package com.lyebook.book.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyebook.book.entity.Article;
import com.lyebook.book.entity.Book;
import com.lyebook.book.entity.Section;
import com.lyebook.book.service.BookServiceIF;
import com.lyebook.book.util.PaChong;
import com.sun.imageio.plugins.common.I18N;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@ComponentScan("com.lzp.ebook.service")
public class BookController {
    @Autowired
    BookServiceIF bookServiceIF;
    PaChong paChong = new PaChong();
    @RequestMapping("allbook")
    public PageInfo<Book> Allbook(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Book> pageInfo = new PageInfo<>(bookServiceIF.AllBook());
        return pageInfo;
    }
    @RequestMapping("insertbook")
    public void insertbook(){
        List<String> list = paChong.paChong2();
        for(String url:list){
            Book book = paChong.getbook(url);
                bookServiceIF.insertBook(book);
        }
    }
    @RequestMapping("intoArt")
    public void intoArticle(){
        bookServiceIF.insertsection();
    }
    @RequestMapping("getneirong")
    public PageInfo<String> gettext(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "300") int pageSize,int bid){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<String> pageInfo = new PageInfo<>(bookServiceIF.getsection(bid));
        return pageInfo;
    }
    @RequestMapping("neirong")
    public void Getcention(){
        List<Integer> bids = bookServiceIF.SelectAllbookid();
        for(Integer bid:bids){
            List<String> urls = bookServiceIF.getsectionurl(bid);
            for(String url:urls){
                System.out.println(url);
                System.out.println(paChong.paChong(url));
            }
        }
    }
    @RequestMapping("getAllSection")
    public PageInfo<Section> GetAllSection(@RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "100") int pageSize, Integer bid){
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Section> pageInfo = new PageInfo<>(bookServiceIF.FindAllSectionById(bid));
        return pageInfo;
    }
}

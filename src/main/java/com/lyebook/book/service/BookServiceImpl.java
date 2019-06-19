package com.lyebook.book.service;

import com.github.pagehelper.Page;
import com.lyebook.book.entity.Article;
import com.lyebook.book.entity.Book;
import com.lyebook.book.entity.Section;
import com.lyebook.book.mapper.BookDao;
import com.lyebook.book.util.PaChong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@ComponentScan("com.lyebook.book.mapper")
public class BookServiceImpl implements BookServiceIF {
    @Autowired
    BookDao bookDao;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<Book> AllBook() {
         return bookDao.SelectBookAll();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void setBookConcent(Book book){
        bookDao.insertBook(book);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void insertBook(Book book){
        bookDao.insertBook(book);
    }
    @Override
    public void insertsection(){
        Section section = new Section();
        PaChong paChong = new PaChong();
        List<Book> books = bookDao.SelectBookId();
        for(Book book:books){
            String url = book.getBookurl();
            int bookid = book.getId();
            List<String> names = paChong.ChapterName(url);
            List<String> sectionurl = paChong.Chapter(url);
            for (int i = 0; i < names.size(); i++) {
                section.setSname(names.get(i));
                section.setBid(bookid);
                section.setSurl(sectionurl.get(i));
                bookDao.insertSection(section);
            }
        }
    }

    /**
     * 根据书id查找对应章节
     * @param bid
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Page<String> getsection(int bid){

        return bookDao.SelectSectionByBid(bid);

    }
    @Override
    public List<Integer> SelectAllbookid(){
        return bookDao.SelectBookid();
    }
    @Override
    public List<String> getsectionurl(int bid){
        return bookDao.getsectionurl(bid);
    }
}

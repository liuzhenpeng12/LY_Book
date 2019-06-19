package com.lyebook.book.service;

import com.github.pagehelper.Page;
import com.lyebook.book.entity.Book;
import com.lyebook.book.entity.Section;

import java.util.List;

public interface BookServiceIF {
    Page<Book> AllBook();
    void setBookConcent(Book book);
    /**
     * 插入book信息
     * @param book
     */
    void insertBook(Book book);

    List<Integer> SelectAllbookid();
    void insertsection();
    List<String> getsectionurl(int bid);

    /**
     * 根据书id查找对应章节
     * @param bid
     * @return
     */
    List<String> getsection(int bid);
    /**
     * 根据bid查找对应的全部章节
     */
    Page<Section> FindAllSectionById(int bid);
}

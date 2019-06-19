package com.lyebook.book.service;

import com.github.pagehelper.Page;
import com.lyebook.book.entity.Book;

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
    List<String> getsection(int bid);
}

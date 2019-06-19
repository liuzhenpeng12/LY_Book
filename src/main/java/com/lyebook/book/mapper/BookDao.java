package com.lyebook.book.mapper;

import com.github.pagehelper.Page;
import com.lyebook.book.entity.Article;
import com.lyebook.book.entity.Book;
import com.lyebook.book.entity.Section;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao {
    Page<Book> SelectBookAll();
    List<Book> SelectBookId();
    void insertBook(Book book);
    void updateBookimgpath(Book book);
    List<Integer> SelectBookid();
    /**
     * 插入section表信息
     * @param section
     */
    void insertSection(Section section);
    List<Integer> SelectSectionId();
    Page<String> SelectSectionByBid(int bid);
    List<String> getsectionurl(int bid);
    //List<String> insertcencent(Article article);
    Page<Section> SelectAllSectionById(int bid);
}

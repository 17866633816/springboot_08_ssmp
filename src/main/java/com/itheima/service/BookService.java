package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;

import java.util.List;

//业务层标准开发
public interface BookService {

    boolean save(Book book);

    boolean delete(int id);

    boolean update(Book book);

    Book getById(int id);

    List<Book> getAll();

    IPage<Book> getPage(int current,int size,Book book);

}

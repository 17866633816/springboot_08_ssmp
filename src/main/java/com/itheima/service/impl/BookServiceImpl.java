package com.itheima.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;


    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>0;
    }

    @Override
    public boolean delete(int id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Book getById(int id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> getAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int current, int size,Book book) {
        IPage<Book> page = new Page<>(current,size);
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<Book>();
        lqw.like(book.getType()!=null,Book::getType,book.getType());
        lqw.like(book.getName()!=null,Book::getName,book.getName());
        lqw.like(book.getDescription()!=null,Book::getDescription,book.getDescription());

        IPage<Book> bookIPage = bookDao.selectPage(page, lqw);
        return bookIPage;
    }
}

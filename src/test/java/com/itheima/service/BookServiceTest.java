package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void save(){
        Book book = new Book();
        book.setType("悬疑");
        book.setName("星际穿越");
        book.setDescription("影史评分最高");
        System.out.println(bookService.save(book));
    }

    /**
     * 删除一条记录
     */
    @Test
    void delete(){
        System.out.println(bookService.delete(15));
    }

    /**
     * 修改一条记录
     */
    @Test
    void update(){
        Book book = new Book();
        book.setId(13);
        book.setType("爱情");
        book.setName("阿甘正传");
        book.setDescription("爱情评分最高");
        System.out.println(bookService.update(book));
    }

    /**
     * 查询单条记录
     */
    @Test
    void getById(){
        Book book = bookService.getById(2);
        System.out.println(book);
    }

    /**
     * 查询全部
     */
    @Test
    void getAll(){
        List<Book> bookList = bookService.getAll();
    }

    /**
     * 分页查询
     */
    @Test
    void getPage(){
        //1.创建Ipage对象
        //2.配置分页拦截器
        IPage page = bookService.getPage(2,5,null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}

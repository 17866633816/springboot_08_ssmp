package com.itheima.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookServiceTest2 {
    @Autowired
    private BookService2 bookService;

    @Test
    void save(){
        Book book = new Book();
        book.setType("科幻");
        book.setName("异型");
        book.setDescription("恐怖系列评分最高");
        System.out.println(bookService.save(book));
    }

    /**
     * 删除一条记录
     */
    @Test
    void delete(){
        System.out.println(bookService.removeById(16));
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
        System.out.println(bookService.updateById(book));
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
        List<Book> bookList = bookService.list();
    }

    /**
     * 分页查询
     */
    @Test
    void getPage(){
        //1.创建Ipage对象
        //2.配置分页拦截器
        IPage page = new Page(2,5);
        IPage bookpage = bookService.page(page,null);
        System.out.println(bookpage.getCurrent());
        System.out.println(bookpage.getSize());
        System.out.println(bookpage.getTotal());
        System.out.println(bookpage.getPages());
        System.out.println(bookpage.getRecords());
    }
}

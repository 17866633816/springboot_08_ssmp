package com.itheima.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookdao;

    /**
     * 添加一条记录
     */
    @Test
    void save(){
        Book book = new Book();
        book.setType("悬疑");
        book.setName("星际穿越");
        book.setDescription("影史评分最高");
        bookdao.insert(book);
    }

    /**
     * 删除一条记录
     */
    @Test
    void delete(){
        bookdao.deleteById(3);
    }

    /**
     * 修改一条记录
     */
    @Test
    void update(){
        Book book = new Book();
        book.setId(12);
        book.setType("喜剧");
        book.setName("夏洛特烦恼");
        book.setDescription("喜剧评分最高");
        bookdao.updateById(book);
    }

    /**
     * 查询单条记录
     */
    @Test
    void getById(){
        Book book = bookdao.selectById(2);
        System.out.println(book);
    }

    /**
     * 查询全部
     */
    @Test
    void getAll(){
        List<Book> bookList = bookdao.selectList(null);
    }

    /**
     * 分页查询
     */
    @Test
    void getPage(){
        //1.创建Ipage对象
        //2.配置分页拦截器
        IPage page = new Page(1,3);
        IPage Page = bookdao.selectPage(page, null);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }

    /**
     * 条件查询
     */
    @Test
    void getByCondition(){
        String name1 = null;

        //方式一
        /*QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name",name1);
        List<Book> bookList = bookdao.selectList(qw);*/

        //方式二
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(name1!=null,Book::getName,name1);
        List<Book> bookList = bookdao.selectList(lqw);
    }

}

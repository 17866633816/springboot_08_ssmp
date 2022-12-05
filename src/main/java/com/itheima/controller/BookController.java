package com.itheima.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itheima.controller.util.R;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        //人工抛出一个异常
        if (book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        System.out.println(flag);
        return new R(flag,flag ? "添加成功^-^":"添加失败-^-");
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable int id){
        return new R(bookService.delete(id));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.update(book));
    }

    @GetMapping("{id}")
    public R getById(@PathVariable int id){
        return new R(true,bookService.getById(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true,bookService.getAll());
    }

 /*   @GetMapping("{current}/{pageSize}")
    public R getPage(@PathVariable Integer current,@PathVariable Integer pageSize){
        IPage<Book> iPage = bookService.getPage(current, pageSize);
        if (current > iPage.getPages()){
            iPage = bookService.getPage((int)iPage.getPages(), pageSize);
        }
        return new R(true,iPage);
    }*/

    @GetMapping("{current}/{pageSize}")
    public R getByCondition(@PathVariable Integer current,@PathVariable Integer pageSize,Book book){
        IPage<Book> iPage = bookService.getPage(current, pageSize,book);
        if (current > iPage.getPages()){
            iPage = bookService.getPage((int)iPage.getPages(), pageSize,book);
        }
        return new R(true,iPage);
    }
}

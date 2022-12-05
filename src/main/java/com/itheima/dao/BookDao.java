package com.itheima.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itheima.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper //用于告诉spring框架此接口的实现类由Mybatis负责创建，并将其实现类对象存储到spring容器中。
public interface BookDao extends BaseMapper<Book> {
}

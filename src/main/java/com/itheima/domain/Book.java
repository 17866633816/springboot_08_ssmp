package com.itheima.domain;

import lombok.Data;

@Data //此注解提供的方法可通过Ctrl+f12查看
public class Book {

    private int id;
    private String type;
    private String name;
    private String description;

}

package com.middlename.demo1.pojo;

public class T1 {
    private Integer id;
    private String name;
    private String author;

    public T1() {
    }

    public T1(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}

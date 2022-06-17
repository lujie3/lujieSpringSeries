package com.middlename.dao;

import com.middlename.pojo.Book;

import java.util.List;

public interface BookDao {
    public void add(Object[] bookargs);
    public void modify(Book info,Integer id);
    public void delete(Integer id);
    public void findCount();
    public Book findByid(Integer id);
    public List<Book> findAll();
    public void batchadd(List<Book> books);
    public void batchdelete(List<Object[]> indes);
    public void batchmodify();
}

package com.middlename.service;

import com.middlename.dao.BookDao;
import com.middlename.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookDao bookdao;

    public void setBookdao(BookDao bookdao) {
        this.bookdao = bookdao;
    }

    public void add(Book info){
        Object[] bookinfo = info.parse();
        bookdao.add(bookinfo);
    }

    public void modify(Book info,Integer id){
        bookdao.modify(info,id);
    }

    public void delete(Integer id){
        bookdao.delete(id);
    }

    public void findCount(){
        bookdao.findCount();
    }

    public Book findByid(Integer id){
        return bookdao.findByid(id);
    }

    public List<Book> findall(){
        return bookdao.findAll();
    }

    public void batchadd(List<Book> books){
        bookdao.batchadd(books);
    }

    public void batchdelete(){
        Object[] ob1 = new Object[]{1};
        Object[] ob2 = new Object[]{2};
        Object[] ob3 = new Object[]{3};
        Object[] ob4 = new Object[]{666};
        List<Object[]> l = new ArrayList<Object[]>();
        l.add(ob1);l.add(ob2);l.add(ob3);l.add(ob4);
        bookdao.batchdelete(l);
    }
}

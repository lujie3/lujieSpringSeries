package com.middlename.dao;

import com.middlename.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void add(Object[] bookargs) {
        String sql = "insert into book values(?,?,?)";
        int i = jdbcTemplate.update(sql, bookargs);
        System.out.println(i);
    }

    @Override
    public void modify(Book info,Integer id) {
        Object[] args = info.parsewithid(id);
        String sql = "update book set bookid=?,bookname=?,author=? where bookid=?";
        int i = jdbcTemplate.update(sql, args);
        System.out.println(i);
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from book where bookid = ?";
        Object[] args = new Object[]{id};
        int i = jdbcTemplate.update(sql, args);
        System.out.println(i);
    }

    @Override
    public void findCount() {
        String sql = "select count(*) from book";
        Integer i = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(i);
    }

    @Override
    public Book findByid(Integer id) {
        String sql = "select * from book where bookid = ?";
        Object[] args = new Object[]{id};
        Book book = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class),args);

        System.out.println(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        String sql = "select * from book";
        List<Book> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Book>(Book.class));

        for(Book ite : list){
            System.out.println(ite);
        }

        return list;
    }

    @Override
    public void batchadd(List<Book> books) {
        List<Object[]> argslist = new ArrayList<Object[]>();
        for(Book ite:books){
            argslist.add(ite.parse());
            System.out.println(ite);
        }

        String sql = "insert into book values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql, argslist);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchdelete(List<Object[]> indes) {
        String sql = "delete from book where bookid = ?";

        int[] ints = jdbcTemplate.batchUpdate(sql, indes);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchmodify() {
        List<Object[]> argslist = new ArrayList<Object[]>();
        String sql = "update book set bookid=?,bookname=?,author=? where bookid=?";
        int[] ints = jdbcTemplate.batchUpdate(sql, argslist);
        System.out.println(Arrays.toString(ints));
    }
}

package com.middlename.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.middlename.pojo.Book;
import com.middlename.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MyTest {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Book info = context.getBean("book", Book.class);info.bind(777,"海贼王","尾田");
        BookService bookService = context.getBean("bookService", BookService.class);

    }

    public void passedTest() throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        //1 测试连接池配置
        DruidDataSource dataSource = context.getBean("dataSource",DruidDataSource.class);
        Connection conn = dataSource.getConnection();
        conn.close();

        //2 测试jdbcTemplate
        JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
        String sql = "select count(*) from book";
        Integer in = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(in);

        //3 测试增删改查
        Book info = context.getBean("book", Book.class);info.bind(222,"海贼王","尾田");
        BookService bookService = context.getBean("bookService", BookService.class);
        //3.1 测试增
        bookService.add(info);
        //3.2 测试改
        Book info2 = context.getBean("book", Book.class);info.bind(444,"海贼王","尾田");
        bookService.modify(info2,111);
        //3.3 测试删
        bookService.delete(444);
        //3.4 测试查
        bookService.findCount();
        System.out.println(bookService.findByid(333));
        bookService.findall();

        //4 测试批量操作
        //批量添加
        Book info1 = context.getBean("book", Book.class);info1.bind(1,"海贼王","尾田");
        Book info4 = context.getBean("book", Book.class);info4.bind(2,"海贼王","尾田");
        Book info3 = context.getBean("book", Book.class);info3.bind(3,"海贼王","尾田");
        List<Book> list1 = new ArrayList<Book>();
        list1.add(info1);list1.add(info4);list1.add(info3);
        bookService.batchadd(list1);
        //批量删
        bookService.batchdelete();
        //批量修改不测试了,封装参数有点麻烦
    }

}

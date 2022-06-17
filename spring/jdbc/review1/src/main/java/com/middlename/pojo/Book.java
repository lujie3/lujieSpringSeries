package com.middlename.pojo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Nullable;

@Component()
@Scope("prototype")
public class Book {
    private Integer bookid;
    private String bookname;
    private String author;

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void bind(Integer id,String name,String author){
        this.setBookid(id);
        this.setBookname(name);
        this.setAuthor(author);
    }

    public Object[] parse(@Nullable Object... rest){
        return new Object[]{this.bookid,this.bookname,this.author};
    }

    public Object[] parsewithid(Integer id){
        return new Object[]{this.bookid,this.bookname,this.author,id};
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bookname='" + bookname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

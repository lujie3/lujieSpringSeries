package com.middlename.demo1.pojo;

public class User {
    private Integer id;
    private String username;
    private String psw;
    private Integer age;
    private char sex;
    private String email;

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPsw() {
        return psw;
    }

    public Integer getAge() {
        return age;
    }

    public char getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public User(Integer id, String username, String psw, Integer age, char sex, String email) {
        this.id = id;
        this.username = username;
        this.psw = psw;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", email='" + email + '\'' +
                '}';
    }
}

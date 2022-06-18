package com.middlename.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void update(Integer id, Integer monument) {
        String addsql = "update account set money = money+? where id=?";
        String subsql = "update account set money = money-? where id=?";
        String sql = null;

        sql = monument>0?addsql:subsql;
        Object[] args = new Object[]{Math.abs(monument),id};

        int i = jdbcTemplate.update(sql, args);
        System.out.println(i);
    }
}

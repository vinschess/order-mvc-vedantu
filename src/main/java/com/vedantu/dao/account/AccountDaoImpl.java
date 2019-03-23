package com.vedantu.dao.account;

import com.vedantu.mapper.AccountMapper;
import com.vedantu.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class AccountDaoImpl implements AccountDao{
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_ACCOUNT = "select * from account where user_name = ?";

    @Autowired
    public AccountDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Account getAccount(String userName) {
        return jdbcTemplate.queryForObject(SQL_FIND_ACCOUNT, new Object[] { userName }, new AccountMapper());
    }

}

package com.vedantu.mapper;

import com.vedantu.models.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class AccountMapper implements RowMapper<Account> {
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setAccountId((UUID) resultSet.getObject("account_id"));
        account.setUserName(resultSet.getString("user_name"));
        return account;
    }
}

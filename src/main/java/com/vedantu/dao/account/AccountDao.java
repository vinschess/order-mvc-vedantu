package com.vedantu.dao.account;

import com.vedantu.models.Account;

public interface AccountDao {
    Account getAccount(String userName);
}

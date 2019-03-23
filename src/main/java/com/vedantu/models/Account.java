package com.vedantu.models;

import java.util.UUID;

public class Account {
    private UUID accountId;
    private String userName;

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", userName='" + userName + '\'' +
                '}';
    }
}

package com.vedantu.models;

import java.util.UUID;

public class Orders {
    private UUID orderId;
    private UUID accountId;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", accountId=" + accountId +
                '}';
    }
}

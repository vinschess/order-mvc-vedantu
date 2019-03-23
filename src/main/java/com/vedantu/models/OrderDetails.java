package com.vedantu.models;

import java.util.UUID;

public class OrderDetails {
    private UUID orderId;
    private UUID inventoryId;
    private Integer totalItems;
    private Double price;

    public UUID getOrderId() {
        return orderId;
    }

    public void setOrderId(UUID orderId) {
        this.orderId = orderId;
    }

    public UUID getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(UUID inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", inventoryId=" + inventoryId +
                ", totalItems=" + totalItems +
                ", price=" + price +
                '}';
    }
}

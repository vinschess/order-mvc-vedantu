package com.vedantu.models;

import java.util.UUID;

public class Inventory {
    private UUID inventoryId;
    private String itemName;
    private Integer totalItem;
    private Double itemPrice;

    public UUID getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(UUID inventoryId) {
        this.inventoryId = inventoryId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(Integer totalItem) {
        this.totalItem = totalItem;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", itemName='" + itemName + '\'' +
                ", totalItem=" + totalItem +
                ", itemPrice=" + itemPrice +
                '}';
    }
}

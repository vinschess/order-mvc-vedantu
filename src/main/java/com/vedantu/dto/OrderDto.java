package com.vedantu.dto;

import java.util.Map;

public class OrderDto {
    private String userName;
    private Map<String, Integer> itemNameCountMap;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Map<String, Integer> getItemNameCountMap() {
        return itemNameCountMap;
    }

    public void setItemNameCountMap(Map<String, Integer> itemNameCountMap) {
        this.itemNameCountMap = itemNameCountMap;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "userName='" + userName + '\'' +
                ", itemNameCountMap=" + itemNameCountMap +
                '}';
    }
}

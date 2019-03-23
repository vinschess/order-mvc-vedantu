package com.vedantu.dao.inventory;

import com.vedantu.models.Inventory;

import java.util.UUID;

public interface InventoryDao {
    Inventory getInventory(String itemName);

    boolean updateInventory(UUID inventoryId, Integer orderItems);
}

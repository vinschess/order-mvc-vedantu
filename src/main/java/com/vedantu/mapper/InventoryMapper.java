package com.vedantu.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.vedantu.models.Inventory;
import org.springframework.jdbc.core.RowMapper;

public class InventoryMapper implements RowMapper<Inventory> {

    public Inventory mapRow(ResultSet resultSet, int i) throws SQLException {
        Inventory inventory = new Inventory();
        inventory.setInventoryId((UUID) resultSet.getObject("inventory_id"));
        inventory.setItemName(resultSet.getString("item_name"));
        inventory.setTotalItem(resultSet.getInt("total_item"));
        inventory.setItemPrice(resultSet.getDouble("item_price"));
        return inventory;
    }
}


package com.vedantu.dao.inventory;

import com.vedantu.mapper.InventoryMapper;
import com.vedantu.models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.UUID;

@Component
public class InventoryDaoImpl implements InventoryDao {

    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_INVENTORY = "select * from inventory where item_name = ?";
    private final String SQL_UPDATE_INVENTORY = "update inventory set total_itmes = total_items - ? where inventory_id = ?";

    @Autowired
    public InventoryDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Inventory getInventory(String itemName) {
        return jdbcTemplate.queryForObject(SQL_FIND_INVENTORY, new Object[] { itemName }, new InventoryMapper());
    }

    public boolean updateInventory(UUID inventoryId, Integer orderItems) {
        return jdbcTemplate.update(SQL_UPDATE_INVENTORY, orderItems, inventoryId) > 0;
    }
}


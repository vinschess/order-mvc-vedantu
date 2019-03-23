package com.vedantu.dao.order;

import com.vedantu.models.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class OrderDetailsDaoImpl implements OrderDetailsDao {

    JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_ORDER_DETAILS = "insert into order_details(order_id, inventory_id, total_items, price) values(?,?,?,?)";

    @Autowired
    public OrderDetailsDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean createOrderDetails(OrderDetails orderDetails) {
        return jdbcTemplate.update(SQL_INSERT_ORDER_DETAILS, orderDetails.getOrderId(), orderDetails.getInventoryId(),
                orderDetails.getTotalItems(), orderDetails.getPrice()) > 0;
    }
}

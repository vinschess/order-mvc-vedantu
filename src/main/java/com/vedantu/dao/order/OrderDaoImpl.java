package com.vedantu.dao.order;

import com.vedantu.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class OrderDaoImpl implements OrderDao {
    JdbcTemplate jdbcTemplate;

    private final String SQL_INSERT_ORDER = "insert into orders(order_id, account_id) values(?,?)";

    @Autowired
    public OrderDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public boolean createOrder(Orders orders) {
        return jdbcTemplate.update(SQL_INSERT_ORDER, orders.getOrderId(), orders.getAccountId()) > 0;
    }
}

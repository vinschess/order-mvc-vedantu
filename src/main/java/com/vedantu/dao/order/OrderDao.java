package com.vedantu.dao.order;

import com.vedantu.models.Orders;

public interface OrderDao {
    boolean createOrder(Orders orders);
}

package com.vedantu;

import com.vedantu.dao.account.AccountDao;
import com.vedantu.dao.inventory.InventoryDao;
import com.vedantu.dao.order.OrderDao;
import com.vedantu.dao.order.OrderDetailsDao;
import com.vedantu.dto.OrderDto;
import com.vedantu.models.Account;
import com.vedantu.models.Inventory;
import com.vedantu.models.OrderDetails;
import com.vedantu.models.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;


@Controller
public class OrderController {

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private InventoryDao inventoryDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public @ResponseBody Boolean addOrder(@RequestBody OrderDto orderDto) {
        Account account = accountDao.getAccount(orderDto.getUserName());
        if(account == null) {
            return false;
        }
        Orders order = new Orders();
        order.setAccountId(account.getAccountId());
        order.setOrderId(UUID.randomUUID());

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : orderDto.getItemNameCountMap().entrySet()) {
            Inventory inventory = inventoryDao.getInventory(entry.getKey());
            if(inventory == null || inventory.getTotalItem() < entry.getValue()) {
                return false;
            }
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setOrderId(order.getOrderId());
            orderDetails.setInventoryId(inventory.getInventoryId());
            orderDetails.setTotalItems(entry.getValue());
            orderDetails.setPrice(entry.getValue()*inventory.getItemPrice());
        }
        orderDao.createOrder(order);
        for(OrderDetails od : orderDetailsList) {
            inventoryDao.updateInventory(od.getInventoryId(), od.getTotalItems());
            orderDetailsDao.createOrderDetails(od);
        }
        return true;
    }
}

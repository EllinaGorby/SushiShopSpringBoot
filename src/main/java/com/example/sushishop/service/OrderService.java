package com.example.sushishop.service;

import com.example.sushishop.model.Order;
import com.example.sushishop.model.OrderItem;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elina Gorby
 */
@Service
public class OrderService {
    
    private Order order = null;

    private final List<OrderItem> orderItemList = new ArrayList<>();

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addOrderItem(OrderItem oi) {
        orderItemList.add(oi);
    }

    public void removeOrderItem(OrderItem oi) {
        orderItemList.remove(oi);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public double sumTotal() {
        double sum = 0;
        for (OrderItem oi : orderItemList) {
            sum = sum + oi.getPrice() * oi.getQuantity();
        }
        return sum;
    }

}

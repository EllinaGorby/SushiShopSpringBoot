package com.example.sushishop.service;

import com.example.sushishop.model.Order;
import com.example.sushishop.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

import com.example.sushishop.repository.OrderRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Elina Gorby
 */
@Service
public class OrderService {

    private Order order = null;

    private List<OrderItem> orderItemList = new ArrayList<>();
    @Autowired
    private OrderRepository orderRepository;

    public OrderService() {
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void addOrderItem(OrderItem oi) {
        orderItemList.add(oi);
    }

    public void removeOrderItem(OrderItem oi) {
        orderItemList.remove(oi);
    }

    public double sumTotal() {
        double sum = 0;
        for (OrderItem oi : orderItemList) {
            sum = sum + oi.getPrice() * oi.getQuantity();
        }
        return sum;
    }

    public boolean saveOrderInRepository() {
        try {
            orderRepository.saveAndFlush(order);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}

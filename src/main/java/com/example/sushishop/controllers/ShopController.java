package com.example.sushishop.controllers;

import com.example.sushishop.model.Dish;
import com.example.sushishop.model.OrderItem;
import com.example.sushishop.service.DishService;
import com.example.sushishop.service.OrderService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Elina Gorby
 */
@Controller
public class ShopController {

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;

    public ShopController() {
    }

    public DishService getDishService() {
        return dishService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    @PostMapping(path = "/plusDish/{id}")
    public String addToOrder(@PathVariable String id) {
        long idLong;
        idLong = Long.parseLong(id);
        Dish d = this.dishService.getDish(idLong);
        OrderItem oi = findDishInOrder(d);
        if (oi != null) {
            oi.plusOne();
        } else {
            orderService.addOrderItem(new OrderItem(d, 1, d.getPrice(), null));
        }
        return "redirect:/sushi-shop";
    }

    @PostMapping(path = "/minusDish/{id}")
    public String removeFromOrder(@PathVariable String id) {
        long idLong;
        idLong = Long.parseLong(id);
        Dish d = this.dishService.getDish(idLong);
        OrderItem oi = findDishInOrder(d);
        if (oi != null) {
            if (oi.minusOne() == 0) {
                orderService.removeOrderItem(oi);
            }
        } 
        return "redirect:/sushi-shop";
    }

    private OrderItem findDishInOrder(Dish d) {
        Optional<OrderItem> optionalOrderItem = orderService.getOrderItemList()
                .stream()
                .filter(oi -> oi.getDish().equals(d))
                .findFirst();
        if (optionalOrderItem.isPresent()) {
            return optionalOrderItem.get();
        }
        return null;
    }
    
}

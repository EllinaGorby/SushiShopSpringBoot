
package com.example.sushishop.controllers;

import com.example.sushishop.model.Dish;
import com.example.sushishop.model.Order;
import com.example.sushishop.repository.DishRepository;
import com.example.sushishop.service.DishService;
import com.example.sushishop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Elina Gorby
 */
@Controller
@RequestMapping(path = "/sushi-shop")
public class DishController {
    
    @Autowired
    private DishService dishService;
    @Autowired
    private OrderService orderService;



    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model){
       // Iterable<Dish> dishes =dishRepository.findAll();
        model.addAttribute("listDish", dishService.getDishList());
        model.addAttribute("orderItemList", orderService.getOrderItemList());
        model.addAttribute("sumTotal", orderService.sumTotal());
        
        return "home.html";
    }

    
//    @GetMapping("/order")
//    Order order(Model model){
//        model.addAttribute("orderItemList", orderService.getOrderItemList());
//        model.addAttribute("sumTotal", orderService.sumTotal());
//        return new Order();
//    }
    
}

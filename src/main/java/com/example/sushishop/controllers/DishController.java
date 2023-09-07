
package com.example.sushishop.controllers;

import com.example.sushishop.configurations.AuthenticationFacade;
import com.example.sushishop.configurations.CustomUserDetails;
import com.example.sushishop.model.Dish;
import com.example.sushishop.model.Order;
import com.example.sushishop.repository.DishRepository;
import com.example.sushishop.service.DishService;
import com.example.sushishop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.Authentication;

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
    @Autowired
    private AuthenticationFacade authenticationFacade;

    public DishController() {

    }

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model,@AuthenticationPrincipal CustomUserDetails userDetails){
       // Iterable<Dish> dishes =dishRepository.findAll();
        model.addAttribute("listDish", dishService.getDishList());
        model.addAttribute("orderItemList", orderService.getOrderItemList());
        model.addAttribute("sumTotal", orderService.sumTotal());
        model.addAttribute("authorization", authenticationFacade.getAuthentication());


        if (userDetails != null) {

           model.addAttribute("username",userDetails.getUsername());//"User Details: " + userDetails.getUsername() + " Lastname " + userDetails.getCustomer().getLastname();
        } else {
            model.addAttribute("username","not authoreized");
        }


        
        return "home.html";
    }

    
//    @GetMapping("/order")
//    Order order(Model model){
//        model.addAttribute("orderItemList", orderService.getOrderItemList());
//        model.addAttribute("sumTotal", orderService.sumTotal());
//        return new Order();
//    }
    
}

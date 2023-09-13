package com.example.sushishop.controllers;


import com.example.sushishop.configurations.CustomUserDetails;
import com.example.sushishop.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.sushishop.service.DishService;
import com.example.sushishop.service.OrderService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;


/**
 *
 * @author Elina Gorby
 */
@Controller
//@RequestMapping(path = "/")
public class OrderController {

//    @Autowired
//    private Order order;
    @Autowired
    private DishService dishService;
    @Autowired
    private OrderService orderService;

    private static Logger log = LoggerFactory.getLogger(OrderController.class);


    public OrderController() {
    }
    
    @PostMapping(path = "/order")
//    @RequestMapping(method = RequestMethod.GET)
    public String orederSite(Model model,@AuthenticationPrincipal CustomUserDetails userDetails){
        model.addAttribute("orderItemList", orderService.getOrderItemList());
        model.addAttribute("sumTotal", orderService.sumTotal());
        orderService.setOrder(new Order());
        model.addAttribute("order", orderService.getOrder());
        if(userDetails!=null) {
            model.addAttribute("customer", userDetails.getCustomer());
        }else
            model.addAttribute("customer", null);
        
        return "order.html";
        
    }

    @PostMapping(path = "/orderCreated")
    public String orderCreated(Model model, HttpServletRequest request){
        orderService.getOrder().setName(request.getParameter("name"));
        orderService.getOrder().setPhone(request.getParameter("phone"));
        orderService.getOrder().setEmail(request.getParameter("email"));
        log.info("++++++++++++++++++++++Name ist "+ request.getParameter("name"));
        //orderService.getOrder().setDateOfDilivery(LocalDateTime.parse(request.getParameter("date")));
        //orderService.getOrder().set(request.getParameter("time"));

        //TODO filling and save for order
        orderService.saveOrderInRepository();
        model.addAttribute("order",orderService.getOrder());

        return "order-created.html";
    }

    
//    public boolean initCustomerInfo(HttpServletRequest request) {
//        String buttonOrderString = request.getParameter("buttonOrder");
//        if (buttonOrderString != null) {
//            String nameString = (String) request.getParameter("name");
//            String phoneString = request.getParameter("phone");
//            String emailString = request.getParameter("email");
//            String addressString = request.getParameter("address");
//            String dateString = request.getParameter("date");
//            String timeString = request.getParameter("time");
//            order.setName(nameString);
//            order.setPhone(phoneString);
//            order.setAddress(addressString);
//            order.setCreateDate(LocalDateTime.now());
//            order.setEmail(emailString);
//
////            order.setDateOfDilivery(nameString);
//            if (nameString == "" || phoneString == "" || emailString == "" || addressString == "" || dateString == "" || timeString == "") {
////                message = "Fülen Sie bitte alle Felder";
//                return false;
//
//            }
////            message = "alle Felder ausgefült";
//            return true;
//        }
//        return false;
//    }
}

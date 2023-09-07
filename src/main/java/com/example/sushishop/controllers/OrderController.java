package com.example.sushishop.controllers;

import com.example.sushishop.configurations.AuthenticationFacade;
import com.example.sushishop.configurations.CustomUserDetails;
import com.example.sushishop.model.Order;
import com.example.sushishop.service.DishService;
import com.example.sushishop.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


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

//    @PostMapping(path = "/orderCreate")
//    public String orederSite(){
//        if (this.initCustomerInfo(request))
//        
//        return "order.html";
//    }
//    
    
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

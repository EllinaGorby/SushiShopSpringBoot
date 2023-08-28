package com.example.sushishop.controllers;

/**
 *
 * @author Elina Gorby
 * Class for testing
 */
import com.example.sushishop.model.Dish;
import java.util.ArrayList;
import java.util.List;

import com.example.sushishop.repository.DishRepository;
import com.example.sushishop.service.DishService;
import com.example.sushishop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private DishService dishService;
    @Autowired
    private OrderService orderService;




    @GetMapping("/")
    public String greeting(Model model) {
        List<Dish> dishs = new ArrayList<>();
        Dish d1 = new Dish(1, "Sake Maki", "mit Lachs", 5, "Roll");
        Dish d2 = new Dish(2, "Sake Negi Maki", "mit Lachs und Lauchzwiebeln", 5, "Roll");
        Dish d3 = new Dish(3, "Tamago Nigiri", "mit Eierstich", 2, "Roll");
        Dish d4 = new Dish(4, "Tamago Nigiri", "mit Eierstich", 6, "Roll");
        Dish d5 = new Dish(5, "Unagi Nigiri", "mit gebratenem und mariniertem Aal", 2, "Roll");
        Dish d6 = new Dish(6, "California Inside Out", "mit Krebsfleischimitat, Avocado und Mayonnaise innen und orangen Capelinrogen außen", 3.8, "Roll");
        Dish d7 = new Dish(7, "Alaska Inside Out", "mit Lachs und Avocado innen und orangen Capelinrogen außen", 2.4, "Roll");
        Dish d8 = new Dish(8, "New York Inside Out", "mit geräuchertem Lachs, Lauchzwiebeln und Avocado innen und Sesam außen", 4.4, "Roll");

        
        dishs.add(d1);
        dishs.add(d2);
        dishs.add(d3);
        dishs.add(d4);
        dishs.add(d5);
        dishs.add(d6);
        dishs.add(d7);
        dishs.add(d8);
        model.addAttribute("listDish1", dishs);
        
        return "home.html";
    }

    @GetMapping("/test")
    public String test(Model model){
        //Iterable<Dish> dishes = dishRepository.findAll();
        /*model.addAttribute("dishes",dishService.getDishList());
        return "test.html";*/
        model.addAttribute("listDish", dishService.getDishList());
        model.addAttribute("orderItemList", orderService.getOrderItemList());
        model.addAttribute("sumTotal", orderService.sumTotal());

        return "home.html";
    }

}

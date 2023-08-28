
package com.example.sushishop.service;

import com.example.sushishop.model.Dish;
import com.example.sushishop.repository.DishRepository;
import java.util.Collections;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elina Gorby
 */

@Service
public class DishService {
    
 
    private DishRepository dishRepository;
    
    
    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository  = dishRepository;
    }
    
    
        

    public List<Dish> getDishList() {
        return dishRepository.findAll();
    }

    public Dish getDish(long id) {
		return dishRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found with id: " + id));
	}	
}

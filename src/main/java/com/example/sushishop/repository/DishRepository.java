

package com.example.sushishop.repository;

import com.example.sushishop.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Elina Gorby
 */
@Repository
public interface DishRepository extends JpaRepository <Dish, Long> {

}

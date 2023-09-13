package com.example.sushishop.repository;

import com.example.sushishop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elina Gorby
 */
@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    public Order findById(long id);
}

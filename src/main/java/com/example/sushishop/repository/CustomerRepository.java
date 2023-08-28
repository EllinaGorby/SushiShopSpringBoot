

package com.example.sushishop.repository;

import com.example.sushishop.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Elina Gorby
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

    public Customer findByEmail(String email);

}

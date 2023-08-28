

package com.example.sushishop.service;

import com.example.sushishop.configurations.CustomUserDetails;
import com.example.sushishop.model.Customer;
import com.example.sushishop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Elina Gorby
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
	private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(username);
        if (customer == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(customer);
    }

}

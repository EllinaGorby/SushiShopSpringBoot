package com.example.sushishop;

import com.example.sushishop.model.Customer;
import com.example.sushishop.model.Dish;
import com.example.sushishop.repository.CustomerRepository;
import com.example.sushishop.repository.DishRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Elina Gorby
 * This class handles the initialization of the database with sample data for the sushi shop application.
 *  It implements the InitializingBean interface, ensuring that the database is populated after the application context is initialized.
 *  It inserts sample dishes and customers if the corresponding repositories are empty.
 */
@Component
public class DBBootstrap implements InitializingBean {

    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private CustomerRepository customerRepository;

    //private static Logger log = LoggerFactory.getLogger(DBBootstrap.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        if (dishRepository.count() != 0) {
            //log.info(Long.toString(dishRepository.count()));
        } else {
            //log.info("dishRepository.count=0");

            List<Dish> dishList = Stream.of(
                            new Dish("Sake Maki", "mit Lachs", 5, "Roll"),
                            new Dish("Sake Negi Maki", "mit Lachs und Lauchzwiebeln", 5, "Roll"),
                            new Dish("Avocado Nigiri", "mit Avocado", 4.5, "Roll"),
                            new Dish("Tamago Nigiri", "mit Eierstich", 6, "Roll"),
                            new Dish("Unagi Nigiri", "mit gebratenem und mariniertem Aal", 2, "Roll"),
                            new Dish("California Inside Out", "mit Krebsfleischimitat, Avocado und Mayonnaise innen und orangen Capelinrogen außen", 3.8, "Roll"),
                            new Dish("Alaska Inside Out", "mit Lachs und Avocado innen und orangen Capelinrogen außen", 2.4, "Roll"),
                            new Dish("New York Inside Out", "mit geräuchertem Lachs, Lauchzwiebeln und Avocado innen und Sesam außen", 4.4, "Roll")
                    )
                    .collect(toList());
            //log.info("Bootstrap dishRepository finished");
            dishRepository.saveAllAndFlush(dishList);

        }
        if (customerRepository.count() == 0) {
            List<Customer> customerList = Stream.of(
                            new Customer("Rosa", "Weis", "LuiseStr.2", "38100", "Braunschweig", "11111111111111", "User", true, "{noop}123456", "123@gmail.com"),
                            new Customer("Karl", "Braun", "LuiseStr.2", "38100", "Braunschweig", "11111111111111", "Admin", true, "{noop}123456", "321@gmail.com")
                    )
                    .collect(toList());
            customerRepository.saveAllAndFlush(customerList);

            //log.info("Bootstrap customerRepository finished");
        }
    }

}

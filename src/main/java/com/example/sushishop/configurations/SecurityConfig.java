package com.example.sushishop.configurations;

import com.example.sushishop.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Ellina Gorby
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, UserDetailsServiceImpl userDetailsService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
//                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(requests -> requests                
//                .requestMatchers("/index.html", "/sushi-shop").permitAll()
//                .antMatchers("/order.html", "/order").authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .anyRequest().authenticated()));
//        return http.build();

        return http.csrf().disable()
                .authorizeHttpRequests(requests -> requests
                .requestMatchers("/sushi-shop","/minusDish/**","/plusDish/**").permitAll()
                //.requestMatchers("/order.html").hasAnyRole("User", "Admin")
                //.requestMatchers("/home.html", "/sushi-shop", "/sushi-shop/**").hasAnyRole("User", "Admin")
                .anyRequest().authenticated())
                .formLogin()/*.loginPage("/login")*/
                .defaultSuccessUrl("/sushi-shop").permitAll()
                //TODO authenticationSuccessHandler()
                /*
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authenticateTheUser")
                .successHandler(authenticationSuccessHandler());
                * */

                .and()
                .logout().permitAll()
                .and()
                .build();
                
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        //return NoOpPasswordEncoder.getInstance();
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/index.html", "/sushi-shop").permitAll()
//                .antMatchers("/order.html", "/order").authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .csrf().disable();
//
////            .formLogin()
////                .loginPage("/login") 
////                .defaultSuccessUrl("/customer/home") 
////                .and()
////            .logout()
////                .logoutUrl("/logout") 
////                .logoutSuccessUrl("/login?logout") 
////                .and()
////            .csrf().disable();
//    }
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authenticationProvider());
//    }
//
//    @Override
}


package com.example.sushishop.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author Ellina Gorby
 */
@Data
@Entity
@Table(name = "custom_order")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime dateOfDilivery;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String name;
    private String address;
    private String zip;
    private String city;
    private String phone;

    public Order() {
    }

    public Order(long id, LocalDateTime createDate, LocalDateTime dateOfDilivery, String email, String name,
                 Customer customer, String address, String zip, String city, String phone) {
        this.id = id;
        this.createDate = createDate;
        this.dateOfDilivery = dateOfDilivery;
        this.customer = null;
        this.email = email;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", createDate=" + createDate + ", dateOfDilivery=" + dateOfDilivery + ", email=" + email + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }

    

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sushishop.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

/**
 *
 * @author Ellina Gorby
 */
@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String zip;
    private String city;
    private String phone;
    private String rolle;
    private boolean enabled;
    private String password;
    private String email;

    public Customer() {
        this("", "", "", "", "", "");
    }

    public Customer(String firstname, String lastname, String address, String zip, String city, String phone, String rolle, boolean enabled, String password, String email) {
        this.id = 0;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
        this.rolle = rolle;
        this.enabled = enabled;
        this.password = password;
        this.email = email;
    }

    public Customer(String firstname, String lastname, String address, String zip, String city, String phone) {
        this(0, "", "", "", "", "", "");

    }

    public Customer(long id, String firstname, String lastname, String address, String zip, String city, String phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phone = phone;

    }

    public String getName() {
        return getFirstname() + " " + getLastname();
    }

    @Override
    public String toString() {
        return getName();
    }

}

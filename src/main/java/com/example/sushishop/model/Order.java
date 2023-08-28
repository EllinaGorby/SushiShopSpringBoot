
package com.example.sushishop.model;

import java.time.LocalDateTime;

/**
 *
 * @author Ellina Gorby
 */
public class Order {
    private long id;
    private LocalDateTime createDate;
    private LocalDateTime dateOfDilivery;
    private String email;
    
//    Customer customer;
    private String name;
    private String address;
    private String zip;
    private String city;
    private String phone;

    public Order() {
    }

    public Order(long id, LocalDateTime createDate, LocalDateTime dateOfDilivery, String email, String name, String address, String zip, String city, String phone) {
        this.id = id;
        this.createDate = createDate;
        this.dateOfDilivery = dateOfDilivery;
        this.email = email;
        this.name = name;
        this.address = address;
        this.zip = zip;
        this.city = city;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getDateOfDilivery() {
        return dateOfDilivery;
    }

    public void setDateOfDilivery(LocalDateTime dateOfDilivery) {
        this.dateOfDilivery = dateOfDilivery;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", createDate=" + createDate + ", dateOfDilivery=" + dateOfDilivery + ", email=" + email + ", name=" + name + ", address=" + address + ", phone=" + phone + '}';
    }

    

}

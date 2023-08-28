package com.example.sushishop.model;

/**
 *
 * @author Ellina Gorby
 */
public class OrderItem {
   
    private long id;
    private Dish dish;
    private int quantity;
    private double price;
    private Order order;

    public OrderItem(long id, Dish dish, int quantity, double price, Order order) {
        this.id = id;
        this.dish = dish;
        this.quantity = quantity;
        this.price = price;
        this.order = order;
        
    }

    public OrderItem(Dish dish, int quantity, double price, Order order) {
        this(0, dish, quantity, price, order);
    }

    public OrderItem() {
        this(0, null, 0, 0,null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    public void plusOne(){
        this.setQuantity(this.getQuantity()+1);
    }
    public int minusOne(){
        this.setQuantity(this.getQuantity()-1);
        return this.getQuantity();
    }

    @Override
    public String toString() {
        return " " + dish + "   " + quantity + "   " + price + ", order:" + order ;
    }
    
}

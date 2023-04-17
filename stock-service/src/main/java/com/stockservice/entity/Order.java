package com.stockservice.entity;

import jakarta.persistence.*;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderId;;
    private String message;
    private String status;
    private String name;
    private int qty;
    private double price;

    public Order(String message, String status, String name, int qty, double price) {
        //this.orderId = orderId;
        this.message = message;
        this.status = status;
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}

package com.satis.orderservice.model;

import lombok.Data;

@Data
public class Product {

    private long id;

    private String productName;

    private int price;

    private int quantity;

    private int total;

}

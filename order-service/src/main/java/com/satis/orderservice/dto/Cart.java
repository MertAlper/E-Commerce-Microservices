package com.satis.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class Cart {

    private String username;

    private List<CartItem> cartItems;


}

package com.satis.orderservice.dto;

import lombok.Data;

@Data
public class CartItem {

    private long productId;

    private int quantity;

}
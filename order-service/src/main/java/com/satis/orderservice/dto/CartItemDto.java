package com.satis.orderservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartItemDto implements Serializable {

    private long productId;

    private int quantity;

}
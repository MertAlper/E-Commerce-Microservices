package com.satis.orderservice.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CartDto implements Serializable {


    private String  username;
    private List<CartItemDto> cartItems;


}

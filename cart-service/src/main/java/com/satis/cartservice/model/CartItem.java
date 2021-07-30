package com.satis.cartservice.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class CartItem  {

    private long productId;
    private int quantity;

}

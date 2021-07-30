package com.satis.cartservice.model;

import lombok.Data;

@Data
public class CartItem {

    private long productId;
    private int quantity;

}

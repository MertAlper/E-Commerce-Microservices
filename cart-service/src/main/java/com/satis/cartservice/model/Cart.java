package com.satis.cartservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Cart {

    @Id
    private String id;

    private String username;

    private List<CartItem> cartItems;

    public void addCartItem(CartItem cartItem) {
        cartItems.add(cartItem);
    }

}

package com.satis.cartservice.service;

import com.satis.cartservice.model.Cart;

import java.util.List;

public interface CartService {

    void save(Cart cart);
    Cart getById(String cartId);
    Cart getByUsername(String username);
    void delete(Cart cart);
    void update(Cart cart);
    void completeOrder(Cart cart);

}

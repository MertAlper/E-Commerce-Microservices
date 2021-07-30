package com.satis.cartservice.dao;

import com.satis.cartservice.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CartDAO extends MongoRepository<Cart, String> {

    @Override
    Optional<Cart> findById(String s);

    Optional<Cart> findByUsername(String username);

}

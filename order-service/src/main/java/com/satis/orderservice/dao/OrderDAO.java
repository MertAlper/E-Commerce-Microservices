package com.satis.orderservice.dao;

import com.satis.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OrderDAO extends MongoRepository<Order, String> {

    @Override
    Optional<Order> findById(String s);

    Optional<Order> findByUsername(String username);

}

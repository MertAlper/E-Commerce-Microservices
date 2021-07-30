package com.satis.orderservice.service;

import com.satis.orderservice.model.Order;

import java.util.List;

public interface OrderService {

    void save(Order order);
    Order getById(String oderId);
    Order getByUsername(String username);
    List<Order> getAll();
    void delete(Order order);

}

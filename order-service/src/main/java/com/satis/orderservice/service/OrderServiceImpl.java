package com.satis.orderservice.service;

import com.satis.orderservice.dao.OrderDAO;
import com.satis.orderservice.exception.OrderNotFoundException;
import com.satis.orderservice.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public void save(Order order) {
        orderDAO.save(order);
    }

    @Override
    public Order getById(String orderId) {
        return orderDAO.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(String.format("Order id %s not found!", orderId)));
    }

    @Override
    public Order getByUsername(String username) {
        Order order = orderDAO.findByUsername(username)
                .orElseThrow(() -> new OrderNotFoundException(String.format("User %s has no order!", username)));

        return order;
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.findAll();
    }

    @Override
    public void delete(Order order) {
        orderDAO.delete(order);
    }

}

package com.satis.orderservice.controller;

import com.satis.orderservice.FeignClient.CustomerClient;
import com.satis.orderservice.model.Order;
import com.satis.orderservice.model.User;
import com.satis.orderservice.response.MessageResponse;
import com.satis.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping("/{username}")
    public ResponseEntity<Order> getOrderById(@PathVariable String username) {

        Order order= orderService.getByUsername(username);

        return ResponseEntity.ok().body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders() {

        List<Order> orders= orderService.getAll();

        return ResponseEntity.ok().body(orders);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> saveOrder(@RequestBody Order order) {

        orderService.save(order);

        MessageResponse response = new MessageResponse("Order is Created");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }



}

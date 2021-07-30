package com.satis.orderservice.controller;

import com.satis.orderservice.FeignClient.CustomerClient;
import com.satis.orderservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    CustomerClient customerClient;

    @GetMapping("/{username}")
    public ResponseEntity<User> getCustomerById(@PathVariable String username) {

        User user =customerClient.getCustomerByUsername(username);

        return ResponseEntity.ok().body(user);
    }
}

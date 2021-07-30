package com.satis.orderservice.listener;

import com.satis.orderservice.FeignClient.CustomerClient;
import com.satis.orderservice.FeignClient.ProductClient;
import com.satis.orderservice.dto.Cart;
import com.satis.orderservice.model.Order;
import com.satis.orderservice.model.Product;
import com.satis.orderservice.model.User;
import com.satis.orderservice.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderListener {

    private final OrderService orderService;

    @Autowired
    private CustomerClient customerClient;

    @Autowired
    private ProductClient productClient;

    public OrderListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = "order-queue")
    public void saveOrder(Cart cart) {
        System.out.println(cart);
        User user = customerClient.getCustomerByUsername(cart.getUsername());
        List<Product> products = new ArrayList<Product>();
//        Order order = new Order();
//        // TODO Order'ı doldur.
//
//        orderService.save(order);
    }

}

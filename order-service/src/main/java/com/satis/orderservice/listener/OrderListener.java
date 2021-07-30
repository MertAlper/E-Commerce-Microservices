package com.satis.orderservice.listener;

import com.satis.orderservice.dto.Cart;
import com.satis.orderservice.model.Order;
import com.satis.orderservice.service.OrderService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    private final OrderService orderService;

    public OrderListener(OrderService orderService) {
        this.orderService = orderService;
    }

    @RabbitListener(queues = "order-queue")
    public void saveOrder(Cart cart) {
        System.out.println(cart);
//        Order order = new Order();
//        // TODO Order'ı doldur.
//
//        orderService.save(order);
    }

}

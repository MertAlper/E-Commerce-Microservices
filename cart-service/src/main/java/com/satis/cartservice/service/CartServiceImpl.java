package com.satis.cartservice.service;

import com.satis.cartservice.dao.CartDAO;
import com.satis.cartservice.dto.CartDto;
import com.satis.cartservice.dto.CartItemDto;
import com.satis.cartservice.exception.CartNotFoundException;
import com.satis.cartservice.exception.UsernameNotFoundException;
import com.satis.cartservice.model.Cart;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Value("${sr.rabbit.queue.name}")
    private String queueName;

    @Value("${sr.rabbit.routing.name}")
    private String routingName;

    @Value("${sr.rabbit.exchange.name}")
    private String exchangeName;

    private final CartDAO cartDAO;
    private final RabbitTemplate rabbitTemplate;

    public CartServiceImpl(CartDAO cartDAO,
                           RabbitTemplate rabbitTemplate) {
        this.cartDAO = cartDAO;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void save(Cart cart) {
        cartDAO.save(cart);
    }

    @Override
    public Cart getById(String cartId) {
        return cartDAO.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(String.format("Cart id %s not found!", cartId)));
    }

    @Override
    public Cart getByUsername(String username) {
        Cart cart = cartDAO.findByUsername(username)
                .orElseThrow(() -> new CartNotFoundException(String.format("User %s has no cart!", username)));

        return cart;
    }

    @Override
    public void delete(Cart cart) {
        cart.setCartItems(null);
        save(cart);
    }

    @Override
    public void update(Cart cart) {
        save(cart);
    }

    @Override
    public void completeOrder(Cart cart) {
        sendToQueue(cart);
    }

    public void sendToQueue(Cart cart) {
         CartDto cartDto = new CartDto();
         cartDto.setListCartDto(cart.getCartItems().stream().map(item->{
             CartItemDto cartItemDto = new CartItemDto();
             cartItemDto.setProductId(item.getProductId());
             cartItemDto.setQuantity(item.getQuantity());
             return cartItemDto;
         }).collect(Collectors.toList())
         );

    }

}

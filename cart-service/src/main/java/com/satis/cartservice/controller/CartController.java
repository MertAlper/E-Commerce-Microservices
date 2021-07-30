package com.satis.cartservice.controller;

import com.satis.cartservice.dao.CartDAO;
import com.satis.cartservice.dto.CartDto;
import com.satis.cartservice.dto.CartItemDto;
import com.satis.cartservice.model.Cart;
import com.satis.cartservice.model.CartItem;
import com.satis.cartservice.response.MessageResponse;
import com.satis.cartservice.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<Cart> getProductById(@PathVariable String cartId) {
        Cart cart = cartService.getById(cartId);

        return ResponseEntity.ok().body(cart);
    }

    @GetMapping("/users/{username}")
    public ResponseEntity<Cart> getByUsername(@PathVariable String username) {
        Cart cart = cartService.getByUsername(username);

        return ResponseEntity.ok().body(cart);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> saveCart(@RequestBody Cart cart) {
        cartService.save(cart);

        MessageResponse response = new MessageResponse("Cart created.");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/users/{username}")
    public ResponseEntity<MessageResponse> updateStock(@PathVariable String username,
                                                       @RequestBody CartItem cartItem) {
        Cart cartInDb = cartService.getByUsername(username);

        Optional<CartItem> firstCartItem = cartInDb.getCartItems()
                .stream()
                .filter(ci -> ci.getProductId() == cartItem.getProductId())
                .findFirst();

        if(firstCartItem.isPresent()) {
            int quantity = firstCartItem.get().getQuantity() + cartItem.getQuantity();
            firstCartItem.get().setQuantity(Math.max(quantity, 0));
        } else {
            cartItem.setQuantity(Math.max(cartItem.getQuantity(), 0));
            cartInDb.addCartItem(cartItem);
        }

        cartService.update(cartInDb);

        MessageResponse response = new MessageResponse("Cart Item updated!");

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/users/{username}")
    public ResponseEntity<MessageResponse> deleteCart(@PathVariable String username) {
        Cart cart = cartService.getByUsername(username);

        cartService.delete(cart);

        MessageResponse response = new MessageResponse(String.format("Cart of %s is flushed.", username));

        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/complete/users/{username}")
    public ResponseEntity<MessageResponse> sendOrder(@PathVariable String username) {
        Cart cart = cartService.getByUsername(username);

        cartService.completeOrder(cart);
        cartService.delete(cart);

        MessageResponse response = new MessageResponse("Order has completed.");

        return ResponseEntity.ok().body(response);
    }

}

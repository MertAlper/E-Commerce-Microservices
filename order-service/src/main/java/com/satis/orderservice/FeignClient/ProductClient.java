package com.satis.orderservice.FeignClient;


import com.satis.orderservice.model.Product;
import com.satis.orderservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("http://localhost:8090/product-service/products")
public interface ProductClient {

    @GetMapping("/{productId}")
    Product getProductById(@PathVariable long productId);



}
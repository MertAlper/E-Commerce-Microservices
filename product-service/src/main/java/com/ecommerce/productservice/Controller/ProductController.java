package com.ecommerce.productservice.Controller;

import com.ecommerce.productservice.Service.IProductService;
import com.ecommerce.productservice.Model.Product;
import com.ecommerce.productservice.DTO.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    Environment env;

    @Autowired
    IProductService productService;

    @GetMapping
    public String welcome(){
        return "HTTP REQUEST HANDLED BY INSTANCE "+env.getProperty("local.server.port");

    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable long productId){




    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO){

        Product product=Product.builder()
                .name(productDTO.getName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice()).build();

        productService.add(product);
        return  ResponseEntity.ok().body("Product is created!");

    }



}

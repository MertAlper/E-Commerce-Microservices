package com.ecommerce.productservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    Environment env;

    @GetMapping
    public String welcome(){
        return "HTTP REQUEST HANDLED BY INSTANCE "+env.getProperty("local.server.port");
    }

}

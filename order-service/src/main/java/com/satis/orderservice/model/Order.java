package com.satis.orderservice.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Order {

    @Id
    private String id;

    private String username;

    private User user;

    private List<Product> products;

}
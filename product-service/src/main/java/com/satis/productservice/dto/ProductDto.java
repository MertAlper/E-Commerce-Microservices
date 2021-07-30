package com.satis.productservice.dto;

import lombok.Data;

@Data
public class ProductDto {

    private long id;
    private String name;
    private int price;
    private int quantity;

}

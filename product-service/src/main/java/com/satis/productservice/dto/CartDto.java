package com.satis.productservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class CartDto {

    List<Long> productIds;
}

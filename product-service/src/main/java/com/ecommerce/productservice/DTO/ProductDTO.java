package com.ecommerce.productservice.DTO;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDTO {

    private String name;

    private String description;

    private float price;

}

package com.satis.productservice.mapper;

import com.satis.productservice.dto.ProductDto;
import com.satis.productservice.model.Product;
import com.satis.productservice.model.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public Product convertToProduct(ProductDto productDto) {
        Stock stock = new Stock();
        stock.setQuantity(productDto.getQuantity());

        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setStock(stock);

        stock.setProduct(product);

        return product;
    }

    public ProductDto convertToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getStock().getQuantity());

        return productDto;
    }

    public List<ProductDto> convertToProductDtoList(List<Product> products) {
        return products.stream()
                .map(this::convertToProductDto)
                .collect(Collectors.toList());
    }

}
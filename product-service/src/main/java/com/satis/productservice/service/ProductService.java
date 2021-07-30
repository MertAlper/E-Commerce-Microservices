package com.satis.productservice.service;

import com.satis.productservice.model.Product;

import java.util.List;

public interface ProductService {

    void save(Product product);

    Product getById(long productId);

    List<Product> getAll();

    List<Product> getAllProductsByIds(List<Long> ids);

    void delete(long productId);

    void update(Product product);

}

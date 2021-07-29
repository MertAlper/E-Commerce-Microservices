package com.ecommerce.productservice.Service;

import com.ecommerce.productservice.Model.Product;

public interface IProductService {
    void add(Product product);
    Product find(long productId);
    void delete (Product product);
    void update(Product product);
}

package com.ecommerce.productservice.Service;

import com.ecommerce.productservice.Repository.ProductRepository;
import com.ecommerce.productservice.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void add(Product product) {

        productRepository.save(product);
    }

    @Override
    public Product find(long id) {

        Optional<Product> product= productRepository.findById(id);

        return product.get();
    }

    @Override
    public void delete(Product product) {

        productRepository.delete(product);
    }

    @Override
    public void update(Product product) {

        productRepository.save(product);
    }

}

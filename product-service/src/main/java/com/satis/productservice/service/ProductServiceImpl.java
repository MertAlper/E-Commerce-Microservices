package com.satis.productservice.service;

import com.satis.productservice.dao.ProductDAO;
import com.satis.productservice.exception.ProductNotFoundException;
import com.satis.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public void save(Product product) {
        productDAO.save(product);
    }

    @Override
    public Product getById(long productId) {
        Product product = productDAO.findById(productId).
                orElseThrow(() -> new ProductNotFoundException(String.format("Product id %d not found", productId)));

        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = productDAO.findAll();

        return products;
    }

    @Override
    public List<Product> getAllProductsByIds(List<Long> ids) {

        return productDAO.findAllProductsByIds(ids);
    }

    @Override
    public void delete(long productId) {
        Product product = getById(productId);

        productDAO.delete(product);
    }

    @Override
    public void update(Product product) {
        save(product);
    }
}

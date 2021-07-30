package com.satis.productservice.dao;

import com.satis.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductDAO extends JpaRepository<Product, Long> {

    //@Query("SELECT p FROM Product p LEFT JOIN FETCH p.stock")
    Optional<Product> findById(long id);

    @Query("SELECT p FROM Product p WHERE p.id in :ids")
    List<Product> findAllProductsByIds(List<Long> ids);

}
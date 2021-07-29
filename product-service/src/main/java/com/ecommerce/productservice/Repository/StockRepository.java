package com.ecommerce.productservice.Repository;

import com.ecommerce.productservice.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository  extends JpaRepository<Stock, Long> {
}

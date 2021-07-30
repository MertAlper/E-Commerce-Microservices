package com.satis.customerservice.dao;


import com.satis.customerservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CustomerDAO extends MongoRepository<Customer, String> {

    @Override
    Optional<Customer> findById(String s);

    Optional<Customer> findByUsername(String username);

}

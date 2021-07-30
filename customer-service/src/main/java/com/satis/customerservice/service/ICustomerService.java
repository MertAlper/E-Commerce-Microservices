package com.satis.customerservice.service;

import com.satis.customerservice.model.Customer;

import java.util.Optional;

public interface ICustomerService {

    void save(Customer customer);
    Optional<Customer> getById(String cartId);
    Customer getByUsername(String username);
    void delete(Customer customer);
    void update(Customer customer);

}

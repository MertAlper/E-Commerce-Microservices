package com.satis.customerservice.service;

import com.satis.customerservice.dao.CustomerDAO;
import com.satis.customerservice.exception.UsernameNotFoundException;
import com.satis.customerservice.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    private CustomerDAO customerDAO;

    public CustomerService(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public Optional<Customer> getById(String customerId) {
        return customerDAO.findById(customerId);
    }

    @Override
    public Customer getByUsername(String username) {
        return customerDAO.findByUsername(username).
                orElseThrow(() -> new UsernameNotFoundException(String.format("Username: %s not found!", username)));
    }

    @Override
    public void delete(Customer customer) {
        customerDAO.delete(customer);

    }

    @Override
    public void update(Customer customer) {
        customerDAO.save(customer);

    }
}

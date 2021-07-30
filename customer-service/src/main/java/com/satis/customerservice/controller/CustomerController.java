package com.satis.customerservice.controller;

import com.satis.cartservice.response.MessageResponse;
import com.satis.customerservice.model.Customer;
import com.satis.customerservice.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/id/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable String customerId) {

        Customer customer = customerService.getById(customerId).get();

        return ResponseEntity.ok().body(customer);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<Customer> getByUsername(@PathVariable String username) {
        Customer customer = customerService.getByUsername(username);

        return ResponseEntity.ok().body(customer);
    }

    @PostMapping
    public ResponseEntity<MessageResponse> saveCustomer(@RequestBody Customer customer) {

        customerService.save(customer);

        MessageResponse response = new MessageResponse("Customer is created.");

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<MessageResponse> deleteCustomer(@PathVariable String username) {

        Customer customer = customerService.getByUsername(username);

        customerService.delete(customer);

        MessageResponse response = new MessageResponse(String.format("User: %s is deleted.", username));

        return ResponseEntity.ok().body(response);
    }




}

package com.satis.orderservice.FeignClient;

import com.satis.orderservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient("http://localhost:8090/customer-service/customer")
public interface CustomerClient {

    @GetMapping("/id/{id}")
     User getCustomerById(@PathVariable String id);

    @GetMapping("/username/{username}")
     User getCustomerByUsername(@PathVariable String username);

}

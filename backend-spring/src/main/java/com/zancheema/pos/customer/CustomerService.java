package com.zancheema.pos.customer;

import com.zancheema.pos.customer.dto.CustomerCreationPayload;
import com.zancheema.pos.customer.dto.CustomerInfo;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerInfo> getCustomers();

    Optional<CustomerInfo> addCustomer(CustomerCreationPayload payload);

    void deleteCustomer(String customerCode);
}

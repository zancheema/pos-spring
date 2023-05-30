package com.zancheema.pos.customer;

import com.zancheema.pos.customer.dto.CustomerCreationPayload;
import com.zancheema.pos.customer.dto.CustomerInfo;
import com.zancheema.pos.util.StreamUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerInfo> getCustomers() {
        return StreamUtil.stream(customerRepository.findAll())
                .map(customer -> new CustomerInfo(customer.getCustomerCode().toString(), customer.getPhoneNumber()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CustomerInfo> addCustomer(CustomerCreationPayload payload) {
        boolean alreadyExists = customerRepository.existsByPhoneNumber(payload.getPhoneNumber());
        if (alreadyExists) {
            return Optional.empty();
        }

        Customer customer = new Customer(null, payload.getPhoneNumber());
        Customer savedCustomer = customerRepository.save(customer);
        CustomerInfo customerInfo = new CustomerInfo(
                savedCustomer.getCustomerCode().toString(),
                customer.getPhoneNumber()
        );
        return Optional.of(customerInfo);
    }

    @Override
    public void deleteCustomer(String customerCode) {
        UUID customerCodeUUID = UUID.fromString(customerCode);
        if (customerRepository.existsById(customerCodeUUID)) {
            customerRepository.deleteById(customerCodeUUID);
        }
    }
}

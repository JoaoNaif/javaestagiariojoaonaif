package com.teste.akross.eclipse_hotel.service.customer;

import com.teste.akross.eclipse_hotel.exception.CustomerNotFound;
import com.teste.akross.eclipse_hotel.model.Customer;
import com.teste.akross.eclipse_hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer execute(String customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFound::new);
    }
}

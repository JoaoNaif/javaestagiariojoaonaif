package com.teste.akross.eclipse_hotel.service.customer;

import com.teste.akross.eclipse_hotel.exception.CustomerNotFound;
import com.teste.akross.eclipse_hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void execute(String customerId) {
        var customer = this.customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFound::new);

        this.customerRepository.delete(customer);
    }
}

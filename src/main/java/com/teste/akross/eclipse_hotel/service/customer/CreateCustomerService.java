package com.teste.akross.eclipse_hotel.service.customer;

import com.teste.akross.eclipse_hotel.exception.CustomerEmailAlreadyExist;
import com.teste.akross.eclipse_hotel.model.Customer;
import com.teste.akross.eclipse_hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CreateCustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer execute(Customer customer) {
        if (this.customerRepository.findByEmail(customer.getEmail()).isPresent()) {
            throw new CustomerEmailAlreadyExist();
        }

        return this.customerRepository.save(customer);
    }
}

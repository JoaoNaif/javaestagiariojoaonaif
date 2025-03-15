package com.teste.akross.eclipse_hotel.service.customer;

import com.teste.akross.eclipse_hotel.dto.UpdateCustomerRequestDTO;
import com.teste.akross.eclipse_hotel.exception.CustomerEmailAlreadyExist;
import com.teste.akross.eclipse_hotel.exception.CustomerNotFound;
import com.teste.akross.eclipse_hotel.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void execute(String customerId, UpdateCustomerRequestDTO request) {
        var customer = customerRepository.findById(customerId)
                .orElseThrow(CustomerNotFound::new);

        var emailExist = customerRepository.findByEmail(request.getEmail()).isPresent();

        if (emailExist) {
            System.out.println(customer.getEmail());
            System.out.println(request.getEmail());
            throw new CustomerEmailAlreadyExist();
        }

        customer.setName(request.getName() != null ? request.getName() : customer.getName());
        customer.setEmail(request.getEmail() != null ? request.getEmail() : customer.getEmail());
        customer.setPhone(request.getPhone() != null ? request.getPhone() : customer.getPhone());

        this.customerRepository.save(customer);
    }
}

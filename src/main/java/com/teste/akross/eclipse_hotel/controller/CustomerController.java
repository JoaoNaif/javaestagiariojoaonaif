package com.teste.akross.eclipse_hotel.controller;

import com.teste.akross.eclipse_hotel.dto.UpdateCustomerRequestDTO;
import com.teste.akross.eclipse_hotel.model.Customer;
import com.teste.akross.eclipse_hotel.service.customer.CreateCustomerService;
import com.teste.akross.eclipse_hotel.service.customer.DeleteCustomerService;
import com.teste.akross.eclipse_hotel.service.customer.GetCustomerService;
import com.teste.akross.eclipse_hotel.service.customer.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CreateCustomerService createCustomerService;

    @Autowired
    private GetCustomerService getCustomerService;

    @Autowired
    private UpdateCustomerService updateCustomerService;

    @Autowired
    private DeleteCustomerService deleteCustomerService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Customer customer) {
        try {
            var result = this.createCustomerService.execute(customer);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Object> get(@PathVariable String customerId) {
        try {
            var result = this.getCustomerService.execute(customerId);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<Object> update(@PathVariable String customerId, @RequestBody UpdateCustomerRequestDTO request) {
        try {
            this.updateCustomerService.execute(customerId, request);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("delete/{customerId}")
    public ResponseEntity<Object> delete(@PathVariable String customerId) {
        try {
            this.deleteCustomerService.execute(customerId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

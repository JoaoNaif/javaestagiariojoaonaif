package com.teste.akross.eclipse_hotel.exception;

public class CustomerNotFound extends  RuntimeException{
    public CustomerNotFound() {
        super("Customer not found");
    }
}

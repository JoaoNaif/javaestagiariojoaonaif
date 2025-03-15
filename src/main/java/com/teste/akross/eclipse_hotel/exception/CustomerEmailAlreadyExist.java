package com.teste.akross.eclipse_hotel.exception;

public class CustomerEmailAlreadyExist extends  RuntimeException{
    public CustomerEmailAlreadyExist() {
        super("Customer email already exist");
    }
}

package com.teste.akross.eclipse_hotel.exception;

public class RoomNumberAlreadyExist extends  RuntimeException{
    public RoomNumberAlreadyExist() {
        super("Room number already exist");
    }
}

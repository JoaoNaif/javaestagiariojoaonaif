package com.teste.akross.eclipse_hotel.exception;

public class RoomNotFound extends RuntimeException{
    public RoomNotFound() {
        super("Room not found");
    }
}

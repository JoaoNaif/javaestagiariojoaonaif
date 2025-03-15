package com.teste.akross.eclipse_hotel.exception;

public class RoomUnavailable extends  RuntimeException {
    public RoomUnavailable() {
        super("Room unavailable");
    }
}

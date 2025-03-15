package com.teste.akross.eclipse_hotel.exception;

public class ReservationNotFound extends RuntimeException{
    public ReservationNotFound() {
        super("Reservation not found");
    }
}

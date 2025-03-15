package com.teste.akross.eclipse_hotel.exception;

public class ReservationDateInvalid extends RuntimeException {
    public ReservationDateInvalid() {
        super("Reservation check-in or check-out invalid");
    }
}

package com.teste.akross.eclipse_hotel.exception;

public class ReservationDeadlineCancellation extends RuntimeException{
    public ReservationDeadlineCancellation() {
        super("The deadline to cancel has passed");
    }
}

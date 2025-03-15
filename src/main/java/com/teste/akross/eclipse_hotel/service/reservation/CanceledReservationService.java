package com.teste.akross.eclipse_hotel.service.reservation;

import com.teste.akross.eclipse_hotel.exception.ReservationDeadlineCancellation;
import com.teste.akross.eclipse_hotel.exception.ReservationNotFound;
import com.teste.akross.eclipse_hotel.model.enums.StatusReservation;
import com.teste.akross.eclipse_hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CanceledReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void execute(String reservationId) {
        var reservation = reservationRepository.findById(reservationId)
                .orElseThrow(ReservationNotFound::new);

        var now = LocalDateTime.now();

        if (now.isAfter(reservation.getCheckIn())) {
            throw new ReservationDeadlineCancellation();
        }

        reservation.setStatus(StatusReservation.CANCELED);

        this.reservationRepository.save(reservation);
    }
}

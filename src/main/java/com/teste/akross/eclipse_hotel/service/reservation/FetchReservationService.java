package com.teste.akross.eclipse_hotel.service.reservation;

import com.teste.akross.eclipse_hotel.dto.FetchReservationResponseDTO;
import com.teste.akross.eclipse_hotel.model.Reservation;
import com.teste.akross.eclipse_hotel.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FetchReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<FetchReservationResponseDTO> execute(LocalDateTime startDate, LocalDateTime endDate) {
        var reservations = reservationRepository.fetchReservation(startDate, endDate);

        return reservations.stream()
                .map(this::convertDTO)
                .toList();
    }

    private FetchReservationResponseDTO convertDTO(Reservation reservation) {
        return FetchReservationResponseDTO.builder()
                .id(reservation.getId())
                .room(reservation.getRoom())
                .checkIn(reservation.getCheckIn())
                .checkOut(reservation.getCheckOut())
                .status(reservation.getStatus())
                .build();
    }
}

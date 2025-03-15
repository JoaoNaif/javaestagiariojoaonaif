package com.teste.akross.eclipse_hotel.service.reservation;

import com.teste.akross.eclipse_hotel.dto.CreateReservationRequestDTO;
import com.teste.akross.eclipse_hotel.exception.CustomerNotFound;
import com.teste.akross.eclipse_hotel.exception.ReservationDateInvalid;
import com.teste.akross.eclipse_hotel.exception.RoomNotFound;
import com.teste.akross.eclipse_hotel.exception.RoomUnavailable;
import com.teste.akross.eclipse_hotel.model.Reservation;
import com.teste.akross.eclipse_hotel.model.enums.StatusReservation;
import com.teste.akross.eclipse_hotel.repository.CustomerRepository;
import com.teste.akross.eclipse_hotel.repository.ReservationRepository;
import com.teste.akross.eclipse_hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Reservation execute(CreateReservationRequestDTO request) {
        if (request.getCheckIn().isAfter(request.getCheckOut())) {
            throw new ReservationDateInvalid();
        }

        var customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(CustomerNotFound::new);

        var room = roomRepository.findById(request.getRoomId())
                .orElseThrow(RoomNotFound::new);

        var roomUnavailable = reservationRepository.findByRoomUnavailable(room.getId());

        if (!roomUnavailable.isEmpty()) {
            throw new RoomUnavailable();
        }

        Reservation reservation = new Reservation();
        reservation.setCustomerId(customer.getId());
        reservation.setRoomId(room.getId());
        reservation.setRoom(room);
        reservation.setCustomer(customer);
        reservation.setCheckIn(request.getCheckIn());
        reservation.setCheckOut(request.getCheckOut());
        reservation.setStatus(StatusReservation.SCHEDULED);


        return this.reservationRepository.save(reservation);
    }
}

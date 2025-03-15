package com.teste.akross.eclipse_hotel.dto;

import com.teste.akross.eclipse_hotel.model.Room;
import com.teste.akross.eclipse_hotel.model.enums.StatusReservation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FetchReservationResponseDTO {

    private String id;
    private Room room;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private StatusReservation status;
}

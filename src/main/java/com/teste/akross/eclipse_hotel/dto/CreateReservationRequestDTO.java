package com.teste.akross.eclipse_hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateReservationRequestDTO {

    private String roomId;
    private String customerId;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
}

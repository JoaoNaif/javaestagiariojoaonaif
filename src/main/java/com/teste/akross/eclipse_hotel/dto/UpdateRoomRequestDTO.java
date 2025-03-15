package com.teste.akross.eclipse_hotel.dto;

import com.teste.akross.eclipse_hotel.model.enums.TypeRoom;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateRoomRequestDTO {

    private Integer roomNumber;
    private TypeRoom type;
    private Double price;
}

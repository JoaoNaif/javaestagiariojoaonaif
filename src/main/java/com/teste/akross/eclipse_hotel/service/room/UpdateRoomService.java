package com.teste.akross.eclipse_hotel.service.room;

import com.teste.akross.eclipse_hotel.dto.UpdateRoomRequestDTO;
import com.teste.akross.eclipse_hotel.exception.RoomNotFound;
import com.teste.akross.eclipse_hotel.exception.RoomNumberAlreadyExist;
import com.teste.akross.eclipse_hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateRoomService {

    @Autowired
    private RoomRepository roomRepository;

    public void execute(String roomId, UpdateRoomRequestDTO request) {
        var room = roomRepository.findById(roomId).orElseThrow(RoomNotFound::new);

        var numberRoomExist = roomRepository.findByRoomNumber(request.getRoomNumber()).isPresent();

        if (numberRoomExist) {
            throw new RoomNumberAlreadyExist();
        }

        room.setRoomNumber(request.getRoomNumber() != null ? request.getRoomNumber() : room.getRoomNumber());
        room.setType(request.getType() != null ? request.getType() : room.getType());
        room.setPrice(request.getPrice() != null ? request.getPrice() : room.getPrice());

        roomRepository.save(room);
    }
}

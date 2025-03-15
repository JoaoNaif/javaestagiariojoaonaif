package com.teste.akross.eclipse_hotel.service.room;

import com.teste.akross.eclipse_hotel.exception.RoomNumberAlreadyExist;
import com.teste.akross.eclipse_hotel.model.Room;
import com.teste.akross.eclipse_hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room execute(Room room) {
        if (this.roomRepository.findByRoomNumber(room.getRoomNumber()).isPresent()) {
            throw new RoomNumberAlreadyExist();
        }

        return roomRepository.save(room);
    }
}

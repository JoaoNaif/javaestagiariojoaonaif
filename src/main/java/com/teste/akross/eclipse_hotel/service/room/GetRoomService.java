package com.teste.akross.eclipse_hotel.service.room;

import com.teste.akross.eclipse_hotel.exception.RoomNotFound;
import com.teste.akross.eclipse_hotel.model.Room;
import com.teste.akross.eclipse_hotel.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetRoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room execute(String roomId) {
        return roomRepository.findById(roomId).orElseThrow(RoomNotFound::new);
    }
}

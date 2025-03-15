package com.teste.akross.eclipse_hotel.repository;

import com.teste.akross.eclipse_hotel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, String> {
    Optional<Room> findByRoomNumber(Integer roomNumber);
}

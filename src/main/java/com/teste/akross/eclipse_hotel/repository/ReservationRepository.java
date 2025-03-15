package com.teste.akross.eclipse_hotel.repository;

import com.teste.akross.eclipse_hotel.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query("SELECT r FROM Reservation r WHERE r.roomId = :roomId AND" +
            "(r.status = 'SCHEDULED' OR r.status = 'IN_USE')")
    List<Reservation> findByRoomUnavailable(@Param("roomId") String roomId);

    @Query("SELECT r FROM Reservation r WHERE " +
            "(r.status = 'SCHEDULED') AND " +
            "((r.checkIn BETWEEN :startDate AND :endDate) OR " +
            "(r.checkOut BETWEEN :startDate AND :endDate) OR " +
            "(r.checkIn <= :startDate AND r.checkOut >= :endDate))")
    List<Reservation> fetchReservation(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

    @Query("SELECT r FROM Reservation r WHERE r.status = 'IN_USE' ")
    List<Reservation> fetchReservationBusy();
}

package com.teste.akross.eclipse_hotel.model;

import com.teste.akross.eclipse_hotel.model.enums.StatusReservation;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "room_id", insertable = false, updatable = false)
    private Room room;

    @Column(name = "room_id", nullable = false)
    private String roomId;

    @ManyToOne()
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "customer_id", nullable = false)
    private String customerId;

    @Column(name = "check_in",nullable = false)
    private LocalDateTime checkIn;

    @Column(name = "check_out",nullable = false)
    private LocalDateTime checkOut;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReservation status;
}

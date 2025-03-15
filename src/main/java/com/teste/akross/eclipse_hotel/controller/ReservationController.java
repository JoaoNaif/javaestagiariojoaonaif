package com.teste.akross.eclipse_hotel.controller;

import com.teste.akross.eclipse_hotel.dto.CreateReservationRequestDTO;
import com.teste.akross.eclipse_hotel.dto.FetchReservationResponseDTO;
import com.teste.akross.eclipse_hotel.service.reservation.CanceledReservationService;
import com.teste.akross.eclipse_hotel.service.reservation.CreateReservationService;
import com.teste.akross.eclipse_hotel.service.reservation.FetchReservationBusyService;
import com.teste.akross.eclipse_hotel.service.reservation.FetchReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private CreateReservationService createReservationService;

    @Autowired
    private CanceledReservationService canceledReservationService;

    @Autowired
    private FetchReservationService fetchReservationService;

    @Autowired
    private FetchReservationBusyService fetchReservationBusyService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody CreateReservationRequestDTO request) {
        try {
          var result = createReservationService.execute(request);
          return ResponseEntity.ok().body(result);
        } catch (Exception e) {
          return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PatchMapping("/canceled/{reservationId}")
    public ResponseEntity<Object> cancel(@PathVariable String reservationId) {
        try {
            canceledReservationService.execute(reservationId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAll(
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        if (startDate == null) {
            startDate = LocalDateTime.now();
        }

        if (endDate == null) {
            endDate = LocalDateTime.now().plusDays(1);
        }

        List<FetchReservationResponseDTO> reservations = fetchReservationService.execute(startDate, endDate);
        return ResponseEntity.ok().body(reservations);
    }

    @GetMapping("/busy")
    public ResponseEntity<Object> getBusy() {
        List<FetchReservationResponseDTO> reservations = fetchReservationBusyService.execute();
        return ResponseEntity.ok().body(reservations);
    }
}

package com.teste.akross.eclipse_hotel.controller;

import com.teste.akross.eclipse_hotel.dto.UpdateRoomRequestDTO;
import com.teste.akross.eclipse_hotel.model.Room;
import com.teste.akross.eclipse_hotel.service.room.CreateRoomService;
import com.teste.akross.eclipse_hotel.service.room.DeleteRoomService;
import com.teste.akross.eclipse_hotel.service.room.GetRoomService;
import com.teste.akross.eclipse_hotel.service.room.UpdateRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private CreateRoomService createRoomService;

    @Autowired
    private GetRoomService getRoomService;

    @Autowired
    private UpdateRoomService updateRoomService;

    @Autowired
    private DeleteRoomService deleteRoomService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@RequestBody Room room) {
        try {
            var result = this.createRoomService.execute(room);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Object> get(@PathVariable String roomId) {
        try {
            var result = this.getRoomService.execute(roomId);
            return ResponseEntity.ok().body(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{roomId}")
    public ResponseEntity<Object> update(@PathVariable String roomId, @RequestBody UpdateRoomRequestDTO request) {
        try {
            this.updateRoomService.execute(roomId, request);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<Object> delete(@PathVariable String roomId) {
        try {
            this.deleteRoomService.execute(roomId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

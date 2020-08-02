package com.yzhan648.lil.learning_spring.business.service;

import com.yzhan648.lil.learning_spring.business.domain.RoomReservation;
import com.yzhan648.lil.learning_spring.data.entity.Guest;
import com.yzhan648.lil.learning_spring.data.entity.Reservation;
import com.yzhan648.lil.learning_spring.data.entity.Room;
import com.yzhan648.lil.learning_spring.data.repository.GuestRepository;
import com.yzhan648.lil.learning_spring.data.repository.ReservationRepository;
import com.yzhan648.lil.learning_spring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReservationService {
    private final RoomRepository roomRepository;
    private final ReservationRepository reservationRepository;
    private final GuestRepository guestRepository;

    @Autowired
    public ReservationService(RoomRepository roomRepository, ReservationRepository reservationRepository, GuestRepository guestRepository) {
        this.roomRepository = roomRepository;
        this.reservationRepository = reservationRepository;
        this.guestRepository = guestRepository;
    }

    public List<RoomReservation> getRoomReservationForDate(Date date) {
        Iterable<Room> rooms = roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservation.setRoomName(room.getName());
            roomReservationMap.put(roomReservation.getRoomId(), roomReservation);
        });
        Iterable<Reservation> reservationsByReservationDate = reservationRepository.findReservationsByReservationDate(new java.sql.Date(date.getTime()));
        reservationsByReservationDate.forEach(r -> {
            RoomReservation roomReservation = roomReservationMap.get(r.getRoomId());
            roomReservation.setDate(date);
            Guest guest = guestRepository.findById(r.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        ArrayList<RoomReservation> roomReservations = new ArrayList<>(roomReservationMap.values());
        roomReservations.sort((o1, o2) -> o1.getRoomName().equals(o2.getRoomName()) ?
                o1.getRoomNumber().compareTo(o2.getRoomNumber()) : o1.getRoomName().compareTo(o2.getRoomName())
        );
        return roomReservations;
    }
}

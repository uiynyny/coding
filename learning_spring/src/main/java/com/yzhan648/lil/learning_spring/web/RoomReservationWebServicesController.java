package com.yzhan648.lil.learning_spring.web;

import com.yzhan648.lil.learning_spring.business.domain.RoomReservation;
import com.yzhan648.lil.learning_spring.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/reservations")
public class RoomReservationWebServicesController {
    private final ReservationService reservationService;

    @Autowired
    public RoomReservationWebServicesController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<RoomReservation> getRoomReservations(@RequestParam(name="date", required = false)String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return reservationService.getRoomReservationForDate(date);
    }
}

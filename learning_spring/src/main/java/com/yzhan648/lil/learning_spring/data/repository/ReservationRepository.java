package com.yzhan648.lil.learning_spring.data.repository;

import com.yzhan648.lil.learning_spring.data.entity.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation,Long> {
    Iterable<Reservation> findReservationsByReservationDate(Date date);
}

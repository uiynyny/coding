package com.yzhan648.lil.learning_spring.data.repository;


import com.yzhan648.lil.learning_spring.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest,Long> {
}

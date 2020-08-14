package com.yzhan648.lil.learning_spring.data.repository;

import com.yzhan648.lil.learning_spring.data.entity.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> {

}

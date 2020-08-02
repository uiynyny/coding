package com.yzhan648.lil.learning_spring.business.service;

import com.yzhan648.lil.learning_spring.data.entity.Guest;
import com.yzhan648.lil.learning_spring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestService {

    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getAllGuests() {
        Iterable<Guest> allGuests = guestRepository.findAll();
        List<Guest> guests = new ArrayList<>();
        allGuests.forEach(guests::add);
        guests.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        return guests;
    }
}

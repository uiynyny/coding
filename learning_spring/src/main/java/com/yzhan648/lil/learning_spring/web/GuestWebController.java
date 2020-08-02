package com.yzhan648.lil.learning_spring.web;

import com.yzhan648.lil.learning_spring.business.service.GuestService;
import com.yzhan648.lil.learning_spring.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(path = "/guests")
public class GuestWebController {
    private final GuestService guestService;

    @Autowired
    public GuestWebController(GuestService guestService) {
        this.guestService = guestService;
    }

    @GetMapping
    public String getAllGuests(Model model) {
        List<Guest> allGuests = guestService.getAllGuests();
        model.addAttribute("guests", allGuests);
        return "guests";
    }
}

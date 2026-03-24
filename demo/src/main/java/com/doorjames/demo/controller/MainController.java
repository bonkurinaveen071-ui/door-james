package com.doorjames.demo.controller;

import com.doorjames.demo.model.Booking;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    private List<Booking> bookings = new ArrayList<>();

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/bookings")
    public String bookingsPage(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("bookings", bookings);
        return "bookings";
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Booking booking, Principal principal, Model model) {

        // Validation
        if (booking.getRoomName() == null || booking.getRoomName().isEmpty()) {
            throw new RuntimeException("Room name is required");
        }

        // Real meeting link
        String meetingLink = "https://meet.google.com/new";
        booking.setMeetingLink(meetingLink);

        bookings.add(booking);

        model.addAttribute("success", "Booking Confirmed!");
        model.addAttribute("booking", booking);
        model.addAttribute("bookings", bookings);

        return "confirmation";
    }
}
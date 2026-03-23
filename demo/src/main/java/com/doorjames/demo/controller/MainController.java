package com.doorjames.demo.controller;

import com.doorjames.demo.model.Booking;
import com.doorjames.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@Controller
public class MainController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/bookings")
    public String bookings(Model model) {
        model.addAttribute("booking", new Booking());
        return "bookings";
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Booking booking, Principal principal, Model model) {

        // Generate meeting link
        String meetingLink = "https://meet.doorjames.com/" + UUID.randomUUID();
        booking.setMeetingLink(meetingLink);

        // Prepare email
        String email = principal.getName();

        String body = "Meeting Room Booked Successfully\n\n" +
                "Room: " + booking.getRoomName() + "\n" +
                "Time: " + booking.getDateTime() + "\n" +
                "Colleagues: " + booking.getColleagues() + "\n" +
                "Meeting Link: " + meetingLink;

        // Send email
        emailService.sendEmail(email, "Meeting Room Booking Confirmation", body);

        model.addAttribute("booking", booking);

        return "confirmation";
    }
}
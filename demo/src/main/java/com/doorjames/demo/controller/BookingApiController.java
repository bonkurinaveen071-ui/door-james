package com.doorjames.demo.controller;

import com.doorjames.demo.model.Booking;
import com.doorjames.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookingApiController {

    @GetMapping("/api/test")
    public String test() {
        return "API WORKING";
    }

    @Autowired
    private EmailService emailService;

    @PostMapping("/book")
    public Booking bookRoom(@RequestBody Booking booking) {

        // Generate meeting link
        String meetingLink = "https://meet.doorjames.com/" + UUID.randomUUID();
        booking.setMeetingLink(meetingLink);

        // Prepare email
        String body = "Meeting Room Booked\n\n" +
                "Room: " + booking.getRoomName() + "\n" +
                "Time: " + booking.getDateTime() + "\n" +
                "Colleagues: " + booking.getColleagues() + "\n" +
                "Meeting Link: " + meetingLink;

        // Send email
        emailService.sendEmail("team@company.com", "Meeting Booked", body);

        return booking;
    }
}
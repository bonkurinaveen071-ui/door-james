package com.doorjames.demo.controller;

import com.doorjames.demo.model.Booking;
import com.doorjames.demo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BookingApiController {

    @GetMapping("/test")
    public String test() {
        return "API WORKING";
    }

    @PostMapping("/book")
    public Booking bookRoom(@RequestBody Booking booking) {
        String meetingLink = "https://meet.doorjames.com/" + UUID.randomUUID();
        booking.setMeetingLink(meetingLink);

        return booking;
    }
}
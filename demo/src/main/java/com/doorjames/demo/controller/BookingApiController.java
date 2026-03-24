package com.doorjames.demo.controller;

import com.doorjames.demo.model.Booking;
import com.doorjames.demo.model.Room;
import com.doorjames.demo.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookingApiController {

    private List<Booking> bookings = new ArrayList<>();

    private List<Room> rooms = List.of(
            new Room("Room A", 5, true),
            new Room("Room B", 8, false),
            new Room("Room C", 10, true)
    );

    @Autowired
    private AuditService auditService;

    @GetMapping("/test")
    public String test() {
        return "API WORKING";
    }

    @PostMapping("/book")
    public Booking bookRoom(@RequestBody(required = false) Booking booking) {

        if (booking == null) {
            booking = new Booking();
        }

        // Dynamic input (from n8n OR fallback)
        int requiredCapacity = booking.getCapacity() != 0 ? booking.getCapacity() : 5;
        boolean needTv = booking.isNeedTv();

        Room selected = null;

        for (Room room : rooms) {
            if (room.getCapacity() >= requiredCapacity && room.isHasTv() == needTv) {
                selected = room;
                break;
            }
        }

        if (selected == null) {
            throw new RuntimeException("No suitable room found");
        }

        // SET ALL FIELDS (IMPORTANT)
        booking.setRoomName(selected.getName());
        booking.setDateTime(java.time.LocalDateTime.now().toString());
        booking.setColleagues("team@company.com");

        String meetingLink = "https://meet.google.com/new";
        booking.setMeetingLink(meetingLink);

        bookings.add(booking);

        auditService.log("Auto-booked room: " + selected.getName());

        return booking;
    }

    @GetMapping("/all")
    public List<Booking> getAllBookings() {
        return bookings;
    }
}
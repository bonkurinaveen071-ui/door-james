package com.doorjames.demo.model;

public class Booking {
    private String roomName;
    private String dateTime;
    private String colleagues;
    private String meetingLink;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getColleagues() {
        return colleagues;
    }

    public void setColleagues(String colleagues) {
        this.colleagues = colleagues;
    }

    public String getMeetingLink() {
        return meetingLink;
    }

    public void setMeetingLink(String meetingLink) {
        this.meetingLink = meetingLink;
    }

    public Booking(String roomName, String dateTime, String colleagues, String meetingLink) {
        this.roomName = roomName;
        this.dateTime = dateTime;
        this.colleagues = colleagues;
        this.meetingLink = meetingLink;
    }
    public Booking(){

    }

    @Override
    public String toString() {
        return "Booking{" +
                "roomName='" + roomName + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", colleagues='" + colleagues + '\'' +
                ", meetingLink='" + meetingLink + '\'' +
                '}';
    }
}

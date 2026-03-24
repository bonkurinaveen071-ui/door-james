package com.doorjames.demo.model;

public class Booking {
    private String roomName;
    private String dateTime;
    private String colleagues;
    private String meetingLink;

    private int capacity;
    private boolean needTv;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isNeedTv() {
        return needTv;
    }

    public void setNeedTv(boolean needTv) {
        this.needTv = needTv;
    }

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

    public Booking(String roomName, String dateTime, String colleagues, String meetingLink, int capacity, boolean needTv) {
        this.roomName = roomName;
        this.dateTime = dateTime;
        this.colleagues = colleagues;
        this.meetingLink = meetingLink;
        this.capacity = capacity;
        this.needTv = needTv;
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
                ", capacity=" + capacity +
                ", needTv=" + needTv +
                '}';
    }
}

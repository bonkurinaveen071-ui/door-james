package com.doorjames.demo.model;

import java.util.Objects;

public class Room {
        private String name;
        private int capacity;
        private boolean hasTv;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isHasTv() {
        return hasTv;
    }

    public void setHasTv(boolean hasTv) {
        this.hasTv = hasTv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getCapacity() == room.getCapacity() && isHasTv() == room.isHasTv() && Objects.equals(getName(), room.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapacity(), isHasTv());
    }
    public Room(String name) {
        this.name = name;
    }

    public Room(String name, int capacity, boolean hasTv) {
        this.name = name;
        this.capacity = capacity;
        this.hasTv = hasTv;
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", hasTv=" + hasTv +
                '}';
    }
}

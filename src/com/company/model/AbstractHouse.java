package com.company.model;

import java.math.BigDecimal;

public abstract class AbstractHouse {
    private final String id;
    private final BigDecimal price;
    private final Integer squareMeter;
    private final Integer numberOfRooms;
    private final Integer numberOfLivingRooms;

    public AbstractHouse(String id, BigDecimal price, Integer squareMeter, Integer numberOfRooms, Integer numberOfLivingRooms) {
        this.id = id;
        this.price = price;
        this.squareMeter = squareMeter;
        this.numberOfRooms = numberOfRooms;
        this.numberOfLivingRooms = numberOfLivingRooms;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getSquareMeter() {
        return squareMeter;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public Integer getNumberOfLivingRooms() {
        return numberOfLivingRooms;
    }
}

package com.company.model;

import java.math.BigDecimal;

public class House extends AbstractHouse {
    public House(String id, BigDecimal price, Integer squareMeter, Integer numberOfRooms, Integer numberOfLivingRooms) {
        super(id, price, squareMeter, numberOfRooms, numberOfLivingRooms);
    }
}

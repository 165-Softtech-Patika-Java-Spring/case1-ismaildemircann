package com.company.model;

import java.math.BigDecimal;

public class Villa extends House{
    public Villa(String id, BigDecimal price, Integer squareMeter, Integer numberOfRooms, Integer numberOfLivingRooms) {
        super(id, price, squareMeter, numberOfRooms, numberOfLivingRooms);
    }
}

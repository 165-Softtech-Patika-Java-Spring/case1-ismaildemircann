package com.company.service;

import com.company.util.HouseListMethods;
import com.company.model.House;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class HouseService {

    private HouseListMethods houseListMethods;

    public HouseService(HouseListMethods houseListMethods) {
        this.houseListMethods = houseListMethods;
    }

    public BigDecimal getTotalPriceOfHouses() {
        return calculateTotalPrice(houseListMethods.getHouseList());
    }

    public BigDecimal getTotalPriceOfVillas() {
        return calculateTotalPrice(houseListMethods.getVillaList());
    }

    public BigDecimal getTotalPriceOfSummerHouses() {
        return calculateTotalPrice(houseListMethods.getSummerHouseList());
    }

    public BigDecimal getTotalPriceAllTypesOfHouses() {
        return calculateTotalPrice(houseListMethods.getAllTypesOfHouseLists());
    }

    public BigDecimal getAvgSquareMetersOfHouses() {
        return calculateAvgSquareMeterHouse(houseListMethods.getHouseList());
    }

    public BigDecimal getAvgSquareMetersOfVillas() {
        return calculateAvgSquareMeterHouse(houseListMethods.getVillaList());
    }

    public BigDecimal getAvgSquareMetersOfSummerHouses() {
        return calculateAvgSquareMeterHouse(houseListMethods.getSummerHouseList());
    }

    public BigDecimal getAvgSquareMetersAllTypesOfHouses() {
        return calculateAvgSquareMeterHouse(houseListMethods.getAllTypesOfHouseLists());
    }

    public ArrayList<String> getHouseListFiltersByNumbersOfRoomAndHall() {
        ArrayList<String> numberOfRoomsAndHallList = new ArrayList<>();
        for (House house : houseListMethods.getAllTypesOfHouseLists()) {
            String numberOfRoomsAndHall = "(" + house.getNumberOfRooms().toString() + " + " +
                    house.getNumberOfLivingRooms().toString() + ")";

            numberOfRoomsAndHallList.add(numberOfRoomsAndHall);
        }
        return numberOfRoomsAndHallList;
    }

    private BigDecimal calculateTotalPrice(ArrayList<House> houseList) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (House house : houseList) {
            totalPrice = totalPrice.add(house.getPrice());
        }
        return totalPrice;
    }

    private BigDecimal calculateAvgSquareMeterHouse(ArrayList<House> houseList) {
        Integer squareMeter = 0;
        for (House house : houseList) {
            squareMeter += house.getSquareMeter();
        }

        BigDecimal avgSquareMeter = new BigDecimal(squareMeter);
        avgSquareMeter = avgSquareMeter.divide(BigDecimal.valueOf(houseList.size()), 2, RoundingMode.CEILING);
        if (avgSquareMeter.scale() > 0) {
            avgSquareMeter = avgSquareMeter.stripTrailingZeros();
        }
        if (avgSquareMeter.scale() < 0) {
            return avgSquareMeter.setScale(0);
        }
        return avgSquareMeter;
    }
}

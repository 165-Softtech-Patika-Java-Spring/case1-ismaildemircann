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
        ArrayList<House> allTypesOfHouseLists = mergeAllHouseList();
        return calculateTotalPrice(allTypesOfHouseLists);
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
        ArrayList<House> allTypesOfHouseLists = mergeAllHouseList();
        return calculateAvgSquareMeterHouse(allTypesOfHouseLists);
    }

    public ArrayList<String> getHouseListFiltersByNumbersOfRoomAndHall() {
        ArrayList<House> allTypesOfHouseLists = mergeAllHouseList();
        ArrayList<String> numberOfRoomsAndHallList = new ArrayList<>();

        for (int i = 0; i < allTypesOfHouseLists.size(); i++) {
            String numberOfRoomsAndHall = "(" + allTypesOfHouseLists.get(i).getNumberOfRooms().toString() + " + "
                    + allTypesOfHouseLists.get(i).getNumberOfLivingRooms().toString() + ")";
            numberOfRoomsAndHallList.add(numberOfRoomsAndHall);
        }
        return numberOfRoomsAndHallList;
    }

    private BigDecimal calculateTotalPrice(ArrayList<House> houseList) {
        BigDecimal totalPrice = new BigDecimal(0);
        for (int i = 0; i < houseList.size(); i++) {
            totalPrice = totalPrice.add(houseList.get(i).getPrice());
        }
        return totalPrice;
    }

    private BigDecimal calculateAvgSquareMeterHouse(ArrayList<House> houseList) {
        Integer squareMeter = 0;
        for (int i = 0; i < houseList.size(); i++) {
            squareMeter += houseList.get(i).getSquareMeter();
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

    private ArrayList<House> mergeAllHouseList() {
        ArrayList<House> allTypesOfHouseLists = new ArrayList<>();
        allTypesOfHouseLists.addAll(houseListMethods.getHouseList());
        allTypesOfHouseLists.addAll(houseListMethods.getVillaList());
        allTypesOfHouseLists.addAll(houseListMethods.getSummerHouseList());
        return allTypesOfHouseLists;
    }
}

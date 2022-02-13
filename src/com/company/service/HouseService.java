package com.company.service;

import com.company.util.HouseDao;
import com.company.model.House;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class HouseService {

    private HouseDao houseDao;

    public HouseService(HouseDao houseListMethods) {
        this.houseDao = houseListMethods;
    }

    /**
     * @return This method returns total price of houses
     */
    public BigDecimal getTotalPriceOfHouses() {
        return calculateTotalPrice(houseDao.getHouseList());
    }

    /**
     * @return This method returns total price of villas
     */
    public BigDecimal getTotalPriceOfVillas() {
        return calculateTotalPrice(houseDao.getVillaList());
    }

    /**
     * @return This method returns total price of summer houses
     */
    public BigDecimal getTotalPriceOfSummerHouses() {
        return calculateTotalPrice(houseDao.getSummerHouseList());
    }

    /**
     * @return This method returns total price all types of houses
     */
    public BigDecimal getTotalPriceAllTypesOfHouses() {
        return calculateTotalPrice(houseDao.getAllTypesOfHouseLists());
    }

    /**
     * @return This method returns average square meters of houses
     */
    public BigDecimal getAvgSquareMetersOfHouses() {
        return calculateAvgSquareMeterHouse(houseDao.getHouseList());
    }

    /**
     * @return This method returns average sguare meters of villas
     */
    public BigDecimal getAvgSquareMetersOfVillas() {
        return calculateAvgSquareMeterHouse(houseDao.getVillaList());
    }

    /**
     * @return This method returns average sguare meters of summer houses
     */
    public BigDecimal getAvgSquareMetersOfSummerHouses() {
        return calculateAvgSquareMeterHouse(houseDao.getSummerHouseList());
    }

    /**
     * @return This method returns average sguare meters all types of houses
     */
    public BigDecimal getAvgSquareMetersAllTypesOfHouses() {
        return calculateAvgSquareMeterHouse(houseDao.getAllTypesOfHouseLists());
    }

    /**
     * @return This method returns house list filters by numbers of room and living room
     */
    public ArrayList<String> getHouseListFiltersByNumbersOfRoomAndLivingRoom() {
        ArrayList<String> numberOfRoomsAndHallList = new ArrayList<>();
        for (House house : houseDao.getAllTypesOfHouseLists()) {
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
        return checkScaleZero(avgSquareMeter);
    }

    private BigDecimal checkScaleZero(BigDecimal squaremeter) {
        if (squaremeter.scale() > 0) {
            squaremeter = squaremeter.stripTrailingZeros();
        }
        if (squaremeter.scale() < 0) {
            return squaremeter.setScale(0);
        }
        return squaremeter;
    }
}

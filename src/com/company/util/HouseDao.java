package com.company.util;

import com.company.model.House;
import com.company.model.SummerHouse;
import com.company.model.Villa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class HouseDao {
    private ArrayList<House> houseList = new ArrayList<>();
    private ArrayList<House> villaList = new ArrayList<>();
    private ArrayList<House> summerHouseList = new ArrayList<>();
    private ArrayList<House> allTypesOfHouseLists = new ArrayList<>();

    public ArrayList<House> getHouseList() {
        return houseList;
    }

    public ArrayList<House> getVillaList() {
        return villaList;
    }

    public ArrayList<House> getSummerHouseList() {
        return summerHouseList;
    }

    public ArrayList<House> getAllTypesOfHouseLists() {
        allTypesOfHouseLists.addAll(houseList);
        allTypesOfHouseLists.addAll(villaList);
        allTypesOfHouseLists.addAll(summerHouseList);
        return allTypesOfHouseLists;
    }

    public void fillAllTypeOfHouseLists() {
        fillHouseList();
        fillVillaList();
        fillSummerHouseList();
    }

    private void fillHouseList() {
        House house1 = new House(UUID.randomUUID().toString(), new BigDecimal(750000), 120, 4, 1);
        House house2 = new House(UUID.randomUUID().toString(), new BigDecimal(500000), 100, 3, 1);
        House house3 = new House(UUID.randomUUID().toString(), new BigDecimal(400000), 80, 2, 1);
        houseList.add(house1);
        houseList.add(house2);
        houseList.add(house3);
    }

    private void fillVillaList() {
        House villa1 = new Villa(UUID.randomUUID().toString(), new BigDecimal(500000), 72, 2, 1);
        House villa2 = new Villa(UUID.randomUUID().toString(), new BigDecimal(550000), 89, 3, 1);
        House villa3 = new Villa(UUID.randomUUID().toString(), new BigDecimal(200000), 25, 1, 0);
        villaList.add(villa1);
        villaList.add(villa2);
        villaList.add(villa3);
    }

    private void fillSummerHouseList() {
        House summerHouse1 = new SummerHouse(UUID.randomUUID().toString(), new BigDecimal(7500000), 720, 5, 2);
        House summerHouse2 = new SummerHouse(UUID.randomUUID().toString(), new BigDecimal(300000), 48, 1, 1);
        House summerHouse3 = new SummerHouse(UUID.randomUUID().toString(), new BigDecimal(600000), 82, 2, 1);
        summerHouseList.add(summerHouse1);
        summerHouseList.add(summerHouse2);
        summerHouseList.add(summerHouse3);
    }
}

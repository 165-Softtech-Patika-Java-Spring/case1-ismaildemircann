package com.company;

import com.company.service.HouseService;
import com.company.util.HouseListMethods;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        HouseListMethods houseListMethods = new HouseListMethods();
        houseListMethods.fillAllTypeOfHouseLists();
        HouseService houseService = new HouseService(houseListMethods);

        System.out.println("------------------------------------------------");
        BigDecimal totalPricesOfHouses = houseService.getTotalPriceOfHouses();
        System.out.println("Evlerin toplam fiyatları: " + totalPricesOfHouses);
        BigDecimal totalPricesOfVillas = houseService.getTotalPriceOfVillas();
        System.out.println("Villaların toplam fiyatları: " + totalPricesOfVillas);
        BigDecimal totalPricesOfSummerHouses = houseService.getTotalPriceOfSummerHouses();
        System.out.println("Yazlıkların toplam fiyatları: " + totalPricesOfSummerHouses);
        BigDecimal totalPriceOfAllTypesOfHouses = houseService.getTotalPriceAllTypesOfHouses();
        System.out.println("Tüm tipteki evlerin toplam fiyatı: " + totalPriceOfAllTypesOfHouses);

        System.out.println("------------------------------------------------");
        BigDecimal avgSquareMetersOfHouses = houseService.getAvgSquareMetersOfHouses();
        System.out.println("Evlerin ortalama metrekaresi: " + avgSquareMetersOfHouses);
        BigDecimal avgSquareMetersOfVillas = houseService.getAvgSquareMetersOfVillas();
        System.out.println("Villaların ortalama metrekaresi: " + avgSquareMetersOfVillas);
        BigDecimal avgSquareMetersOfSummerHouses = houseService.getAvgSquareMetersOfSummerHouses();
        System.out.println("Yazlıkların ortalama metrekaresi: " + avgSquareMetersOfSummerHouses);
        BigDecimal avgSquareMetersOfAllTypesOfHouses = houseService.getAvgSquareMetersAllTypesOfHouses();
        System.out.println("Tüm tipteki evlerin ortalama metrekaresi: " + avgSquareMetersOfAllTypesOfHouses);

        System.out.println("------------------------------------------------");
        ArrayList<String> houseListFiltersByNumbersOfRoomAndHall = houseService.getHouseListFiltersByNumbersOfRoomAndHall();
        System.out.println("Oda ve salon sayısına göre tüm tipteki evleri filtrele: " + houseListFiltersByNumbersOfRoomAndHall);
    }
}

package com.leetcode.ood;

/**
 * ood.Solution
 */
public class Solution {

    public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        ParkingLot pl = new ParkingLot(1, 1, 11);
        pl.parkVehicle(new Motorcycle());
        pl.parkVehicle(car1);
        pl.parkVehicle(car2);
        pl.parkVehicle(car3);
        pl.parkVehicle(car3);
        pl.parkVehicle(car4);
        pl.parkVehicle(new Bus());
        pl.unParkVehicle(car4);
        pl.parkVehicle(new Bus());
    }
}
package com.leetcode.ood.parkingLot;

import java.util.ArrayList;
import java.util.List;

public abstract class Vehicle {
    private VehicleSize carSize;
    private String plateNumber;
    private int spotNeeded;
    private List<ParkingSpot> parkingSpots;

    public Vehicle(VehicleSize carSize, String plateNumber, int spotNeeded) {
        this.carSize = carSize;
        this.plateNumber = plateNumber;
        this.spotNeeded = spotNeeded;
        this.parkingSpots = new ArrayList<>(spotNeeded);
    }

    abstract boolean canFitSpot(ParkingSpot spot);

    public VehicleSize getCarSize() {
        return carSize;
    }

    public void setCarSize(VehicleSize carSize) {
        this.carSize = carSize;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getSpotNeeded() {
        return spotNeeded;
    }

    public void setSpotNeeded(int spotNeeded) {
        this.spotNeeded = spotNeeded;
    }

    public void print(){
        System.out.println("V");
    }

    public void parkInSpot(ParkingSpot spot) {
        parkingSpots.add(spot);
    }

    public void clearSpots() {
        for (int i = 0; i < parkingSpots.size(); i++) {
            parkingSpots.get(i).removeVehicle();
        }
        parkingSpots.clear();
    }
}

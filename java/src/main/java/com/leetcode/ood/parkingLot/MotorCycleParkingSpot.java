package com.leetcode.ood.parkingLot;

public class MotorCycleParkingSpot extends ParkingSpot {

    public MotorCycleParkingSpot(int spotNumber, int row, Level level) {
        super(spotNumber, row, level);
        this.spotSize = VehicleSize.MotorCycle;
    }
}

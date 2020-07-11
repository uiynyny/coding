package com.ood.parkingLot;

public class LargeParkingSpot extends ParkingSpot{
    public LargeParkingSpot(int spotNumber, int row, Level level) {
        super(spotNumber, row, level);
        this.spotSize=VehicleSize.Large;
    }
}

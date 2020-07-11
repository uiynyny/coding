package com.ood.parkingLot;

public class CompactParkingSpot extends ParkingSpot {

    public CompactParkingSpot(int spotNumber, int row, Level level) {
        super(spotNumber, row, level);
        this.spotSize = VehicleSize.Compact;
    }
}

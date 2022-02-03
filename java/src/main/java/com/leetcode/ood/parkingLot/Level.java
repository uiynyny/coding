package com.leetcode.ood.parkingLot;

public class Level {
    private int floor;
    private ParkingSpot[] parkingSpotList;
    private int availableSpots;
    private int SPOT_PER_ROW;

    public Level(int floor, int num_rows, int spot_per_row) {
        this.floor = floor;
        this.availableSpots = 0;
        this.SPOT_PER_ROW = spot_per_row;
        this.parkingSpotList = new ParkingSpot[num_rows * SPOT_PER_ROW];

        int numberSpot = 0;
        for (int row = 0; row < num_rows; row++) {
            int spot = 0;
            for (; spot < SPOT_PER_ROW / 4; spot++) {
                parkingSpotList[spot] = new MotorCycleParkingSpot(spot, row, this);
                numberSpot++;
            }
            for (; spot < SPOT_PER_ROW * 3 / 4; spot++) {
                parkingSpotList[spot] = new CompactParkingSpot(spot, row, this);
                numberSpot++;
            }
            for (; spot < SPOT_PER_ROW; spot++) {
                parkingSpotList[spot] = new LargeParkingSpot(spot, row, this);
                numberSpot++;
            }
        }
        availableSpots = numberSpot;
    }

    public void freeSpot() {
        availableSpots++;
    }

    public boolean parkVehicle(Vehicle v) {
        if (availableSpots() < v.getSpotNeeded()) return false;
        int spotNumber = findAvailableSpot(v);
        if(spotNumber<v.getSpotNeeded()){
            return false;
        }
        return parkStringAtSpot(spotNumber,v);
    }

    private boolean parkStringAtSpot(int spotNumber, Vehicle v) {
        v.clearSpots();
        boolean success=true;
        for(int i=spotNumber;i<v.getSpotNeeded();i++){
            success&=parkingSpotList[i].park(v);
        }
        availableSpots-=v.getSpotNeeded();
        return success;
    }

    private int availableSpots() {
        return availableSpots;
    }

    private int findAvailableSpot(Vehicle v) {
        int spotNeeded = v.getSpotNeeded();
        int lastRow = -1;
        int spotFound = 0;

        for (int i = 0; i < parkingSpotList.length; i++) {
            ParkingSpot spot = parkingSpotList[i];
            if (lastRow != spot.row) {
                spotFound = 0;
                lastRow = spot.row;
            }
            if (spot.canFitVehicle(v)) {
                spotFound++;
            }
            if (spotFound == v.getSpotNeeded()) {
                return i - spotNeeded + 1;
            }
        }
        return -1;
    }
}

package com.ood.parkingLot;

public abstract class ParkingSpot {
    protected VehicleSize spotSize;
    protected int spotNumber;
    protected int row;
    protected Vehicle vehicle;
    protected Level level;

    public ParkingSpot(int spotNumber, int row, Level level) {
        this.spotNumber = spotNumber;
        this.row = row;
        this.level = level;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean park(Vehicle v) {
        if (!canFitVehicle(v)) {
            return false;
        }
        this.vehicle = v;
        vehicle.parkInSpot(this);
        return true;
    }

    public void removeVehicle() {
        this.vehicle = null;
        level.freeSpot();
    }

    public boolean canFitVehicle(Vehicle v) {
        return (isAvailable() && v.canFitSpot(this));

    }

    public void print() {
        if (vehicle == null) {
            if (spotSize == VehicleSize.Compact) {
                System.out.print("c");
            } else if (spotSize == VehicleSize.Large) {
                System.out.print("l");
            } else if (spotSize == VehicleSize.MotorCycle) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }
}

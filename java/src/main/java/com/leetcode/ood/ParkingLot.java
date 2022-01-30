package com.leetcode.ood;

import java.util.ArrayList;
import java.util.List;

// enum type for ood.Vehicle
enum VehicleSize {
    MOTORCYCLE,
    COMPACT,
    LARGE,
}

abstract class Vehicle {
    // Write your code here
    VehicleSize vehicleSize;
    int spotNeed;
    Level atLevel;
    List<int[]> spots;

    public void unpark() {
        for (int[] s : spots) {
            atLevel.spot[s[0]][s[1]] = 0;
        }
        atLevel = null;
        spots = null;
    }

    abstract int[] getRange(int m);
}

class Motorcycle extends Vehicle {
    // Write your code here
    Motorcycle() {
        vehicleSize = VehicleSize.MOTORCYCLE;
        spotNeed = 1;
    }

    @Override
    public int[] getRange(int m) {
        return new int[]{0, m};
    }
}

class Car extends Vehicle {
    // Write your code here
    Car() {
        vehicleSize = VehicleSize.COMPACT;
        spotNeed = 1;
    }

    public int[] getRange(int m) {
        return new int[]{m / 4, m};
    }
}

class Bus extends Vehicle {
    // Write your code here
    Bus() {
        vehicleSize = VehicleSize.LARGE;
        spotNeed = 5;
    }

    public int[] getRange(int m) {
        return new int[]{m / 4 * 3, m};
    }
}

/* Represents a level in a parking garage */
class Level {
    // Write your code here
    int row, col, id;
    int[][] spot;

    public Level(int id, int m, int n) {
        this.row = m;
        this.col = n;
        this.id = id;
        this.spot = new int[m][n];
    }

    public boolean parkVehicle(Vehicle vehicle) {
        int[] range = vehicle.getRange(col);
        int consecSpot = 0;
        List<int[]> alloc = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = range[0]; j < range[1]; j++) {
                if (spot[i][j] == 1) {
                    // has taken
                    consecSpot = 0;
                    alloc = new ArrayList<>();
                    continue;
                }

                consecSpot++;
                alloc.add(new int[]{i, j});
                if (consecSpot == vehicle.spotNeed) {
                    vehicle.atLevel = this;
                    vehicle.spots = new ArrayList<>(alloc);
                    for (int[] p : alloc)
                        spot[p[0]][p[1]] = 1;
                    return true;
                }
            }
        }
        return false;
    }
}

public class ParkingLot {

    // @param n number of leves
    // @param num_rows each level has num_rows rows of spots
    // @param spots_per_row each row has spots_per_row spots
    List<Level> levels;

    public ParkingLot(int n, int numRows, int spotsPerRow) {
        // Write your code here
        levels = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            levels.add(new Level(n, numRows, spotsPerRow));
        }
    }

    // Park the vehicle in a spot (or multiple spots)
    // Return false if failed
    public boolean parkVehicle(Vehicle vehicle) {
        // Write your code here
        for (Level l : levels) {
            if (l.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    // unPark the vehicle
    public void unParkVehicle(Vehicle vehicle) {
        // Write your code here
        vehicle.unpark();
    }
}
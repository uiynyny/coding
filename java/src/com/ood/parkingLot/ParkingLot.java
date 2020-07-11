package com.ood.parkingLot;

public class ParkingLot {
    private Level[] levels;
    private int NUM_LEVEL;

    public ParkingLot(int num_levels, int rows, int num_per_row) {
        this.NUM_LEVEL = num_levels;
        levels=new Level[NUM_LEVEL];
        for(int i=0;i<NUM_LEVEL;i++){
            levels[i]=new Level(i,rows,num_per_row);
        }
    }

    public boolean parkVehicle(Vehicle v){
        for(int i=0;i<NUM_LEVEL;i++){
            if(levels[i].parkVehicle(v)){
                return true;
            }
        }
        return false;
    }

    public void unParkVehicle(Vehicle v){
        v.clearSpots();
    }
}

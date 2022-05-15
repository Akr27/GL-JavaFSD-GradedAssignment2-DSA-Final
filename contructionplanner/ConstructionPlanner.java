package com.gl.javafsd.dsa.gradedassignment2.contructionplanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConstructionPlanner {

    private int totalFloors;

    ArrayList<Integer> floorSizeArray = new ArrayList<>();
    ArrayList<Integer> daySizeArray = new ArrayList<>();
    ArrayList<ArrayList<Integer>> calculatedFloorSizeArray = new ArrayList<>();

    public void floorSizeArrayCalculator(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors: ");
        int totalFloors = sc.nextInt();

        for(int i=0;i<totalFloors;i++){
            int day=i+1;
            System.out.println("Enter the floor size given on day "+day+" : ");
            int floorSize = sc.nextInt();
            floorSizeArray.add(floorSize);
        }

    }

    public void dayWiseWorkCalculator() {

        floorSizeArrayCalculator();

        for (int i=0;i<totalFloors;i++){
            boolean cond = daySizeArray.isEmpty();

            if(floorSizeArray.get(i)== Collections.max(floorSizeArray) && cond){
                daySizeArray.add(floorSizeArray.get(i));
                floorSizeArray.set(i,0);
                calculatedFloorSizeArray.add(i,daySizeArray);
                daySizeArray.clear();
            }

            else if(floorSizeArray.get(i)==Collections.max(floorSizeArray) && !cond){
                ArrayList<Integer> tempDaySizeArray= new ArrayList<>();
                tempDaySizeArray.add(floorSizeArray.get(i));

                for (int j=0;j<=daySizeArray.size();j++){
                    if(daySizeArray.get(j)>Collections.max(floorSizeArray)){
                        tempDaySizeArray.add(daySizeArray.get(j));
                        daySizeArray.set(j,0);
                    }

                    else {
                        continue;
                    }

                calculatedFloorSizeArray.add(i,tempDaySizeArray);

                }

                floorSizeArray.set(i,0);
                tempDaySizeArray.clear();
            }

            else {
                daySizeArray.add(floorSizeArray.get(i));
                floorSizeArray.set(i,0);
                ArrayList<Integer> nullArray = new ArrayList<>();
                calculatedFloorSizeArray.add(i,nullArray);
            }
        }

        System.out.println("The order of construction is as follows:"+totalFloors);
        for (int i=0;i<totalFloors;i++){
            int day = i+1;
            System.out.println("Day  "+day+" : "+calculatedFloorSizeArray.get(i));
        }

    }


}

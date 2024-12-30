package com.xworkz.pro1.ProInterface;

import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {

        ArrayList<String> bikes = new ArrayList<>();
        bikes.add("S1000RR");
        bikes.add("Classic 50");
        bikes.add("GT 650");
        bikes.add("M1000RR");
        bikes.add("Zx10R");
        bikes.add("GSA");
        bikes.add("Domi 250");
        bikes.add("Domi 400");
        bikes.add("Himalayan 450");
        bikes.add("Xpulse");
        System.out.println(bikes);
        System.out.println("Bikes:"+bikes.size());

        System.out.println("After Clearing");
        bikes.clear();
        System.out.println(bikes.size());

    }
}

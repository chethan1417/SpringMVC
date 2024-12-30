package com.xworkz.pro2.runner;


import java.util.ArrayList;
import java.util.Collection;

public class Runner  {

    public static void main(String[] args) {


        Collection<Integer> scores = new ArrayList<>();
        scores.add(18);
        scores.add(1);
        scores.add(100);
        scores.add(121);
        scores.add(21);
        scores.add(22);
        scores.add(44);
        scores.add(55);
        scores.add(154);
        scores.add(143);
        System.out.println(scores);
        System.out.println(scores.size());

        System.out.println("After Clearing");
        scores.clear();
        System.out.println(scores.size());

    }

}

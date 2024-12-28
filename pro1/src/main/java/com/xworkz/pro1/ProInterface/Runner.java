package com.xworkz.pro1.ProInterface;

public class Runner {

    public static void main(String[] args) {

        ProductInterface productInterface= (int a,int b)-> a*b;
        int ref = productInterface.display(3,3);
        System.out.println(ref);
    }
}

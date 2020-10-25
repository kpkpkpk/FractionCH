package com.company;

public class Main {

    public static void main(String[] args) {
        Fraction f=new Fraction(1,2);
        Fraction s=new Fraction(1,4);
        Fraction.getSum(f,s);
        Fraction.getDifference(f,s);
        Fraction.getMultiplication(f,s);
        Fraction.getDivision(f,s);
    }
}

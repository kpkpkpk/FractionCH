package com.company;

public class Fraction {
    private int numerator;//числитель
    private int denominator;//знаменатель

    public Fraction(int numerator, int denominator) {
        if (isZeroDenominator(denominator)) {
            System.out.println("Denominator can't be zero");
            System.exit(0);
        } else {
            this.numerator = numerator * (denominator < 0 ? -1 : 1);//если знаменатель меньше единицы, то умножим сразу же числитель, чтоб не было проблем
            this.denominator = Math.abs(denominator);//знаменатель всегда положительный
            reduce();//сокращаем дроби на их наибольший делитель, чтобы было легче работать
        }
    }

    private boolean isZeroDenominator(int denominator) {
        return denominator == 0;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        if (isZeroDenominator(denominator)) {
            System.out.println("Denominator can't be zero");
            System.exit(0);
        } else {
            if (denominator < 0) {
                numerator *= -1;
            }
            this.denominator = Math.abs(denominator);
        }
    }

    public int getDenominator() {
        return denominator;
    }

    //НОД
    private int gcd(int numerator, int denominator) {
        while (numerator != 0 && denominator != 0) {
            if (numerator > denominator) {
                numerator %= denominator;
            } else {
                denominator %= numerator;
            }
        }
        return denominator + numerator;
    }

    //сокращает дробь
    private void reduce() {
        numerator /= gcd(Math.abs(numerator), Math.abs(denominator));
        denominator /= gcd(Math.abs(numerator), Math.abs(denominator));
    }
    //возврат смешанной дроби.1.получение целой части
    private int getFullPart() {
        return numerator / denominator;
    }
//    возврат смешанной дроби.2. остаточная часть
    private int getSecondPart(){
        return numerator%denominator;
    }


    public void printResult(){
        System.out.println("Результат в виде обыкновенной дроби:"+"\n"+getNumerator()+"\n"+"---"+"\n"+getDenominator());
        System.out.println("Результат в виде смешанной дроби:"+"\n"+"   "+getSecondPart()+"\n"+getFullPart()+"---"+"\n"+"   "+getDenominator());
    }
}

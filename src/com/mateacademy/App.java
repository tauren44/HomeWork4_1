package com.mateacademy;

public class App {
    public static void main(String[] args) {
        System.out.println(Calculator.calculate(5, '+', 3));
        System.out.println(Calculator.calculate(5, '-', 3));
        System.out.println(Calculator.calculate(5, '*', 3));
        System.out.println(Calculator.calculate(6, '/', 3));
        System.out.println(Calculator.calculate(9, 'r', 3));
        System.out.println(Calculator.calculate(6, '^', 3));
        System.out.println(Calculator.calculate(6, '&', 3));
    }
}

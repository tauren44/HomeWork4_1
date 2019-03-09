package com.mateacademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Calculator {
    private static Map<Character, BinaryOperator<Double>> equations
            = new HashMap<Character, BinaryOperator<Double>>() {{
            put('+', (x, y) -> x + y);
            put('-', (x, y) -> x - y);
            put('*', (x, y) -> x * y);
            put('/', (x, y) -> x / y);
            put('r', (x, y) -> Math.pow(x, 1 / y));
            put('^', Math::pow);
            put('&', (x, y) -> Math.pow(((x + y) / (x + 117)), y));
        }};

    public static double calculate(double x, char operation, double y) {
       return Optional.ofNullable(equations.get(operation)).orElseThrow(() ->
                new IllegalArgumentException("Illegal operator. List of operators : +,-,*,/,r,^,&"))
               .apply(x ,y);

    }
}

package com.mateacademy;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class Calculator {
    private static Map<Character, BinaryOperator<Double>> equations;

    static {
        BinaryOperator<Double> add = (x, y) -> x + y;
        BinaryOperator<Double> sub = (x, y) -> x - y;
        BinaryOperator<Double> multiply = (x, y) -> x * y;
        BinaryOperator<Double> div = (x, y) -> x / y;
        BinaryOperator<Double> mathRoot = (x, y) -> Math.pow(x, 1 / y);
        BinaryOperator<Double> pow = Math::pow;
        BinaryOperator<Double> expr = (x, y) -> Math.pow(((x + y) / (x + 117)), y);

        equations = new HashMap<Character, BinaryOperator<Double>>() {{
            put('+', add);
            put('-', sub);
            put('*', multiply);
            put('/', div);
            put('r', mathRoot);
            put('^', pow);
            put('&', expr);
        }};
    }

    public static double calculate(double x, char operation, double y) {
        Optional.ofNullable(equations.get(operation)).orElseThrow(() ->
                new IllegalArgumentException("Illegal operator. List of operators : +,-,*,/,r,^,&"));
        BinaryOperator<Double> result = equations.get(operation);
        return result.apply(x, y);
    }
}

package ru.netology;

import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    //<Integer, Integer>
    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : Integer.MAX_VALUE;
    //BinaryOperator<Integer> devide = (x, y) -> x / y;

    //<Integer, Integer>
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    //<Integer, boolean>
    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Object> println = System.out::println;
}






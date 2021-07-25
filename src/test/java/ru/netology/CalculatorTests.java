package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CalculatorTests {
    Calculator calculator;

    @BeforeEach
    public void init() {
        calculator = new Calculator();
    }

    @AfterEach
    public void tearDown() {
        calculator = null;
    }

    @Test
    public void shouldMultiply_success() {
        System.out.println("Test N 1");
        int a = 8;
        int b = 4;
        int expected = 32;

        int result = calculator.multiply.apply(a, b);

        assertThat(result, equalTo(expected));
    }

    @Test
    public void shouldDivide_success() {
        System.out.println("Test N 2");
        int c = 8;
        int d = 0;

        boolean throwException = false;

        try {
            calculator.devide.apply(c, d);
        } catch (ArithmeticException exception) {
            throwException = true;
        }
        assertThat(throwException, equalTo(false));
    }

    @ParameterizedTest
    @ValueSource(ints = {8, 5, 124, 1})
    public void shouldPositive_success(int argument) {
        System.out.println("Test N 3");

        assertThat(calculator.isPositive.test(argument), equalTo(true));
    }

    //
    @ParameterizedTest
    @ValueSource(ints = {25, 64})
    public void shouldSelectionFromCollection_success(int argument) {
        System.out.println("Test N 4");
        List<Integer> list = Arrays.asList(calculator.pow.apply(5), calculator.pow.apply(-8));
        assertThat(list, hasItem(argument));
    }

    @ParameterizedTest
    @ValueSource(ints = {11, 14})
    public void shouldOperationsWithNumbers_success(int argument) {
        System.out.println("Test N 5");
        assertThat(calculator.abs.apply(argument),
                allOf(greaterThan(5), lessThanOrEqualTo(17), not(equalTo(12))));
        calculator.println.accept("Проверка завершена.");
    }
}




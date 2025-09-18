package com.titiplex.demo;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calc;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void setup() {
        calc = new Calculator();
    }

    @Test
    void testAddition() {
        assertEquals(5, calc.add(2, 3));
    }

    @Test
    void testDivision() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5, 0));
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 7})
    void testIsEven(int number) {
        assertTrue(calc.isEven(number));
    }

    @Disabled("Feature not implemented yet")
    @Test
    void testFutureFeature() {
        fail("To be implemented");
    }

    @AfterEach
    void tearDown() {
        System.out.println("After Each");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("After All");
    }
}
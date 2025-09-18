package com.titiplex.advanced;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DynamicTests {

    @TestFactory
    Stream<DynamicTest> dynamic_add_tests() {
        record Case(int a, int b, int expected) {
        }
        List<Case> cases = List.of(new Case(1, 2, 3), new Case(5, 5, 10), new Case(-1, 1, 0));
        Calculator calc = new Calculator();
        return cases.stream().map(c ->
                DynamicTest.dynamicTest("add %d + %d = %d".formatted(c.a(), c.b(), c.expected()),
                        () -> assertEquals(c.expected(), calc.add(c.a(), c.b()))
                )
        );
    }
}

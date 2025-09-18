package com.titiplex.advanced;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParameterizedAndSourcesTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 4, 100})
    @DisplayName("@ValueSource: even numbers")
    void value_source_isEven(int n) {
        assertTrue(new Calculator().isEven(n));
    }

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "10,5,15",
            "-2, 2, 0"
    })
    @DisplayName("@CsvSource: add cases")
    void csv_source_add(int a, int b, int expected) {
        assertEquals(expected, new Calculator().add(a, b));
    }

    static Stream<Arguments> pairs() {
        return Stream.of(
                Arguments.of(5, 2, 3),
                Arguments.of(0, 1, -1),
                Arguments.of(9, 4, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("pairs")
    @DisplayName("@MethodSource: sub cases")
    void method_source_sub(int expected, int a, int b) {
        assertEquals(expected, new Calculator().sub(a, b));
    }

    enum Parity {EVEN, ODD}

    @ParameterizedTest
    @EnumSource(Parity.class)
    @DisplayName("@EnumSource: parity check")
    void enum_source(Parity parity) {
        boolean isEven = new Calculator().isEven(parity == Parity.EVEN ? 2 : 3);
        assertEquals(parity == Parity.EVEN, isEven);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"a@b.com"})
    @DisplayName("@NullSource/@EmptySource combined with @ValueSource")
    void null_empty_value_sources(String email) {
        if (email == null || email.isEmpty()) {
            assertTrue(email == null || email.isEmpty());
        } else {
            assertTrue(email.contains("@"));
        }
    }
}

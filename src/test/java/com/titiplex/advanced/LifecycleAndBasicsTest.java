package com.titiplex.advanced;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LifecycleAndBasicsTest {

    static Calculator shared;
    Calculator calc;

    @BeforeAll
    static void before_all() {
        shared = new Calculator();
        System.out.println("BeforeAll once");
    }

    @BeforeEach
    void before_each() {
        calc = new Calculator();
    }

    @AfterEach
    void after_each() {
        // cleanup logic if needed
    }

    @AfterAll
    static void after_all() {
        System.out.println("AfterAll once");
    }

    @Test
    @Order(1)
    @DisplayName("add() should sum two integers")
    void test_add() {
        assertEquals(5, calc.add(2, 3));
        assertEquals(5, shared.add(2, 3));
    }

    @Test
    @Order(2)
    void division_by_zero_should_throw() {
        assertThrows(ArithmeticException.class, () -> calc.div(1, 0));
    }

    @Test
    @Order(3)
    @Timeout(1)
    void operation_should_finish_under_1s() {
        assertTrue(calc.isEven(42));
    }

    @Test
    @Order(4)
    @Tag("slow")
    void tagged_test_example() {
        assertEquals(9, calc.mul(3, 3));
    }

    @Disabled("Example of temporarily disabled test")
    @Test
    void disabled_test_example() {
        Assertions.fail("should be skipped");
    }
}

package com.titiplex.advanced;

import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RepeatedAndAssumptionsTest {

    @RepeatedTest(3)
    void repeated_isEven_property() {
        assertTrue(new Calculator().isEven(2));
    }
}

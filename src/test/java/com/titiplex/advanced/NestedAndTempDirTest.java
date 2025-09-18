package com.titiplex.advanced;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("BankAccount behaviour")
class NestedAndTempDirTest {

    BankAccount acc;

    @Nested
    @DisplayName("When new account with initial balance 100")
    class WithInitialBalance {
        @BeforeEach
        void init() {
            acc = new BankAccount(100);
        }

        @Test
        void deposit_increases_balance() {
            acc.deposit(50);
            assertEquals(150, acc.balance());
        }

        @Test
        void withdraw_decreases_balance() {
            acc.withdraw(40);
            assertEquals(60, acc.balance());
        }

        @Test
        void cannot_withdraw_more_than_balance() {
            assertThrows(IllegalStateException.class, () -> acc.withdraw(1000));
        }
    }
}

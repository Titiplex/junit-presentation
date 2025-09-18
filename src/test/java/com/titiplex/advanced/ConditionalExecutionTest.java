package com.titiplex.advanced;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ConditionalExecutionTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void only_on_windows() {
        assertTrue(System.getProperty("os.name").toLowerCase().contains("win"));
    }

    @Test
    @DisabledOnOs(OS.MAC)
    void disabled_on_mac() {
        assertTrue(true);
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "CI", matches = "true")
    void only_on_ci_env() {
        assertTrue(true);
    }
}

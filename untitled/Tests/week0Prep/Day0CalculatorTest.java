package week0Prep;

import java.time.DayOfWeek;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class Day0CalculatorTest {

    @org.junit.jupiter.api.Test
    void testAdd() {
        Day0Calculator calc = new Day0Calculator();
        int result = calc.add(2, 3);
        assertEquals(5, result);
    }

    @org.junit.jupiter.api.Test
    void testSubtract() {
        Day0Calculator calc = new Day0Calculator();
        int result = calc.subtract(10, 4);
        assertEquals(6, result);
    }
}
package com.calculator;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class CGPACalculatorTest {

    @Test
    public void testCGPA() {
        Subject s1 = new Subject("CS101", 9.0, 4);   // Grade Points: 9.0 * 4 = 36.0
        Subject s2 = new Subject("MA101", 8.5, 3);   // Grade Points: 8.5 * 3 = 25.5

        // Total = 36.0 + 25.5 = 61.5, Total credits = 7
        // CGPA = 61.5 / 7 = 8.785714 ≈ 8.79

        double result = CGPACalculator.calculateCGPA(Arrays.asList(s1, s2));
        assertEquals(8.79, result, 0.01); // 0.01 margin for rounding
    }
}

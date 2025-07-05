package com.calculator;

import java.util.List;

public class CGPACalculator {

    public static double calculateCGPA(List<Subject> subjects) {
        double totalPoints = 0;
        int totalCredits = 0;

        for (Subject subject : subjects) {
            totalPoints += subject.getGradePoint() * subject.getCredit();
            totalCredits += subject.getCredit();
        }

        return totalCredits == 0 ? 0 : totalPoints / totalCredits;
    }
}

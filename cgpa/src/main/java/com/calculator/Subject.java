package com.calculator;

public class Subject {
    private String code;
    private double gradePoint;
    private int credit;

    public Subject(String code, double gradePoint, int credit) {
        this.code = code;
        this.gradePoint = gradePoint;
        this.credit = credit;
    }

    public double getGradePoint() {
        return gradePoint;
    }

    public int getCredit() {
        return credit;
    }

    public String getCode() {
        return code;
    }
}

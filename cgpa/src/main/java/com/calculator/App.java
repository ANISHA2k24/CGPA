package com.calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Student Name or ID: ");
        String studentName = sc.nextLine().trim();

        
        Map<String, Integer> subjectCredits = new LinkedHashMap<>();
        subjectCredits.put("21CSE07 - AWS", 3);
        subjectCredits.put("21CSE32 - NR", 3);
        subjectCredits.put("21CSF20 - CD", 3);
        subjectCredits.put("21CSF23 - OOAD", 3);
        
        subjectCredits.put("21CSF34 - JP", 3);
        subjectCredits.put("21CSF21 - CDL", 1);
        subjectCredits.put("21CSF24 - CTL", 1);
        subjectCredits.put("21CSF35 - JPL", 1);

        List<Subject> subjects = new ArrayList<>();

        System.out.println("\nEnter the grade point for each subject:");

        for (Map.Entry<String, Integer> entry : subjectCredits.entrySet()) {
            String code = entry.getKey();
            int credit = entry.getValue();

            System.out.print(code + " (Credit " + credit + "): ");
            double gradePoint = sc.nextDouble();

            subjects.add(new Subject(code, gradePoint, credit));
        }

        double cgpa = CGPACalculator.calculateCGPA(subjects);
        System.out.printf("\n CGPA for %s is: %.2f\n", studentName, cgpa);

        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cgpa_result.txt", true))) {
            writer.write("\n");
            writer.write("Student Name: " + studentName + "\n");

            for (Subject s : subjects) {
                writer.write(String.format("Subject: %s | Grade Point: %.1f | Credit: %d\n",
                        s.getCode(), s.getGradePoint(), s.getCredit()));
            }

            writer.write(String.format("Final CGPA: %.2f\n", cgpa));
            writer.write("\n\n");

           
        } catch (IOException e) {
            System.out.println(" Error writing to file: " + e.getMessage());
        }

        sc.close();
    }
}

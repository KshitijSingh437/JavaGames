package games;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GPACalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalPoints = 0;
        int totalCredits = 0;
        do {
            int credits = getValidCredits(scanner);
            int gradeValue = getValidGrade(scanner);
            int points = gradeValue * credits;

            totalPoints += points;
            totalCredits += credits;

            System.out.println("Would you like to enter another class? (Y/N)");
        } while (scanner.nextLine().equalsIgnoreCase("Y"));

        double gpa = (double) totalPoints / totalCredits;
        DecimalFormat df = new DecimalFormat("0.00");

        System.out.println("Credits: " + totalCredits);
        System.out.println("Points: " + totalPoints);
        System.out.println("GPA: " + df.format(gpa));

        scanner.close();
    }

    private static int getValidCredits(Scanner scanner) {
        while (true) {
            System.out.println("Enter number of credits:");
            String creditsString = scanner.nextLine();
            try {
                return Integer.parseInt(creditsString);
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter a valid credit.");
            }
        }
    }

    private static int getValidGrade(Scanner scanner) {
        while (true) {
            System.out.println("Enter grade (A/B/C/D/F):");
            String gradeString = scanner.nextLine().toUpperCase();
            switch (gradeString) {
                case "A":
                    return 4;
                case "B":
                    return 3;
                case "C":
                    return 2;
                case "D":
                    return 1;
                case "F":
                    return 0;
                default:
                    System.out.println("Invalid grade. Please enter a valid grade.");
            }
        }
    }
}

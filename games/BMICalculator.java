package games;

import java.text.DecimalFormat;
import java.util.Scanner;

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validWeight = false;
        double doubleWeight = 0;
        String weight;
        do {
            try {
                System.out.println("Enter weight in pounds: ");
                weight = scanner.nextLine();
                doubleWeight = Double.parseDouble(weight);
                validWeight = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Hey! you didn't enter your correct weight :(");
            }
        } while (!validWeight);

        System.out.println("Enter height in inches: ");
        double height = scanner.nextDouble();

        double bmi = doubleWeight / Math.pow(height, 2) * 703;
        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println("Your bmi is: " + df.format(bmi));
    }
}

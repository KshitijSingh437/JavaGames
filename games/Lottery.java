package games;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Lottery {

    private static final int NUM_COUNT = 6;
    private static final int MAX_NUMBER = 49;

    public static void main(String[] args) {
        List<Integer> winningNumbers = generateWinningNumbers();
        List<Integer> guessedNumbers = new ArrayList<>();

        System.out.println("Please enter your 6 numbers between 1 and 49");
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            System.out.println("Your current numbers are " + guessedNumbers);
            System.out.println("Please enter a number (1-49)");
            while (true) {
                try {
                    String numberString = scanner.nextLine();
                    int number = Integer.parseInt(numberString);
                    if (number >= 1 && number <= 49) {
                        guessedNumbers.add(number);
                        break;
                    } else {
                        System.out.println(number + " is not between 1 and 49. Please try again!");
                    }
                } catch (NumberFormatException nfe) {
                    System.out.println("Dude, that's not even a number. Please try again.");
                }
            }
        }
        System.out.println("The winning numbers were: " + winningNumbers);
        System.out.println("Your numbers are: " + guessedNumbers);

        guessedNumbers.retainAll(winningNumbers);

        System.out.println("Your matched numbers are " + guessedNumbers);

        if (guessedNumbers.containsAll(winningNumbers)) {
            System.out.println("Holy Crap, You actually Won! How did you do that?");
        } else {
            System.out.println("Sorry, you lost. Not surprising!");
        }

        scanner.close();
    }

    private static List<Integer> generateWinningNumbers() {
        List<Integer> winningNumbers = new ArrayList<>();
        Random random = new Random();

        while (winningNumbers.size() < NUM_COUNT) {
            int winningNumber = random.nextInt(MAX_NUMBER) + 1;
            if (!winningNumbers.contains(winningNumber)) {
                winningNumbers.add(winningNumber);
            }
        }
        return winningNumbers;
    }
}


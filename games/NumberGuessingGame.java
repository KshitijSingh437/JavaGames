package games;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);

        int randomNumber = rand.nextInt(100) + 1;

        int playerGuess;
        while (true) {
            System.out.println("Enter your guess (1-100):");
            playerGuess = scanner.nextInt();
            if (playerGuess == randomNumber) {
                System.out.println("Correct! You Win!");
                break;
            } else if (randomNumber > playerGuess) {
                System.out.println("Nope! The number is higher. Guess again.");
            } else {
                System.out.println("Nope! The number is lower. Guess again.");
            }
        }
    }
}

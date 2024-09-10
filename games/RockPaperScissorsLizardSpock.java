package games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsLizardSpock {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rpslk = {"rock", "paper", "scissors", "lizard", "spock"};
        Random random = new Random();

        while (true) {
            String computerMove = rpslk[random.nextInt(rpslk.length)];
            String playerMove;
            while (true) {
                System.out.print("Please enter your move (rock, paper, scissors, lizard or spock): ");
                playerMove = scanner.nextLine().toLowerCase();
                if (isValidMove(playerMove)) {
                    break;
                }
                System.out.println(playerMove + " is not a valid move.");
            }
            System.out.println("Computer Played: " + computerMove);

            if (playerMove.equals(computerMove)) {
                System.out.println("The game is a tie!");
            } else if (playerMove.equals("rock")) {
                switch (computerMove) {
                    case "paper" -> System.out.println("Paper covers rock. You lose!");
                    case "scissors" -> System.out.println("Rock crushes scissors. You win!");
                    case "lizard" -> System.out.println("Rock crushes lizard. You win!");
                    case "spock" -> System.out.println("Spock vaporizes rock. You lose!");
                }
            } else if (playerMove.equals("paper")) {
                switch (computerMove) {
                    case "rock" -> System.out.println("Paper covers rock. You win!");
                    case "scissors" -> System.out.println("Scissors cuts paper. You lose!");
                    case "lizard" -> System.out.println("Lizard eats paper. You lose!");
                    case "spock" -> System.out.println("Paper disproves spock. You win!");
                }
            } else if (playerMove.equals("scissors")) {
                switch (computerMove) {
                    case "rock" -> System.out.println("Rock crushes scissors. You lose!");
                    case "paper" -> System.out.println("Scissors cuts paper. You win!");
                    case "lizard" -> System.out.println("Scissors decapitates lizards. You win!");
                    case "spock" -> System.out.println("Spock smashes scissors. You lose!");
                }
            } else if (playerMove.equals("lizard")) {
                switch (computerMove) {
                    case "rock" -> System.out.println("Rock crushes lizard. You lose!");
                    case "paper" -> System.out.println("Lizard eats paper. You win!");
                    case "scissors" -> System.out.println("Scissors decapitates lizards. You lose!");
                    case "spock" -> System.out.println("Lizard poisons spock. You win!");
                }
            } else {
                switch (computerMove) {
                    case "rock" -> System.out.println("Spock vaporizes rock. You win!");
                    case "paper" -> System.out.println("Paper disproves spock. You lose!");
                    case "scissors" -> System.out.println("Spock smashes scissors. You win!");
                    case "lizard" -> System.out.println("Lizard poisons spock. You lose!");
                }
            }
            System.out.println("Play again? (y/n): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("y")) {
                break;
            }
        }
    }

    private static boolean isValidMove(String move) {
        return move.equals("rock") || move.equals("paper") || move.equals("scissors") ||
                move.equals("lizard") || move.equals("spock");
    }
}

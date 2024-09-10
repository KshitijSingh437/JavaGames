package games;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3;
    private static final char EMPTY = ' ';
    private static final char PLAYER_SYMBOL = 'X';
    private static final char COMPUTER_SYMBOL = 'O';

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[SIZE][SIZE];
        initializeBoard(board);
        printBoard(board);

        while (true) {
            playerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
            computerTurn(board);
            if (isGameFinished(board)) {
                break;
            }
            printBoard(board);
        }
    }

    private static void playerTurn(char[][] board) {
        String playerMove;
        while (true) {
            System.out.println("Where would you like to play? (1-9)");
            playerMove = scanner.nextLine();
            if (isValidMove(board, playerMove)) {
                break;
            } else {
                System.out.println(playerMove + " is not a valid player move :(");
            }
        }
        placeMove(board, playerMove, PLAYER_SYMBOL);
    }

    private static void computerTurn(char[][] board) {
        Random random = new Random();
        int computerMove;
        while (true) {
            computerMove = random.nextInt(9) + 1;
            if (isValidMove(board, String.valueOf(computerMove))) {
                break;
            } else {
                System.out.println(computerMove + " is not a valid computer move :(");
            }
        }
        System.out.println("Computer Chose " + computerMove);
        placeMove(board, String.valueOf(computerMove), COMPUTER_SYMBOL);
    }

    private static boolean isValidMove(char[][] board, String position) {
        return switch (position) {
            case "1" -> board[0][0] == ' ';
            case "2" -> board[0][1] == ' ';
            case "3" -> board[0][2] == ' ';
            case "4" -> board[1][0] == ' ';
            case "5" -> board[1][1] == ' ';
            case "6" -> board[1][2] == ' ';
            case "7" -> board[2][0] == ' ';
            case "8" -> board[2][1] == ' ';
            case "9" -> board[2][2] == ' ';
            default -> false;
        };
    }

    private static void placeMove(char[][] board, String position, char playerSymbol) {
        switch (position) {
            case "1":
                board[0][0] = playerSymbol;
                break;
            case "2":
                board[0][1] = playerSymbol;
                break;
            case "3":
                board[0][2] = playerSymbol;
                break;
            case "4":
                board[1][0] = playerSymbol;
                break;
            case "5":
                board[1][1] = playerSymbol;
                break;
            case "6":
                board[1][2] = playerSymbol;
                break;
            case "7":
                board[2][0] = playerSymbol;
                break;
            case "8":
                board[2][1] = playerSymbol;
                break;
            case "9":
                board[2][2] = playerSymbol;
                break;
            default:
                System.out.println(":(");
        }
    }

    private static boolean isGameFinished(char[][] board) {
        if (hasContestantWon(board, PLAYER_SYMBOL)) {
            printBoard(board);
            System.out.println("PLAYER WINS!!!");
            return true;
        }

        if (hasContestantWon(board, COMPUTER_SYMBOL)) {
            printBoard(board);
            System.out.println("COMPUTER WINS!!!");
            return true;
        }

        if (isBoardFull(board)) {
            printBoard(board);
            System.out.println("The game ended in a Tie!");
            return true;
        }
        return false;
    }

    private static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasContestantWon(char[][] board, char playerSymbol) {
        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((board[i][0] == playerSymbol && board[i][1] == playerSymbol && board[i][2] == playerSymbol) ||
                    (board[0][i] == playerSymbol && board[1][i] == playerSymbol && board[2][i] == playerSymbol)) {
                return true;
            }
        }
        // Check for diagonals
        return (board[0][0] == playerSymbol && board[1][1] == playerSymbol && board[2][2] == playerSymbol) ||
                (board[0][2] == playerSymbol && board[1][1] == playerSymbol && board[2][0] == playerSymbol);
    }

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}

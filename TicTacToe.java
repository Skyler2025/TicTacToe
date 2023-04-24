
/**
 * Write a description of class TicTacToe here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Tic Tac Toe");

        int xWinCount = 0;
        int oWinCount = 0;
        int moveCount = 0;

        printBoard();
        System.out.println("Welcome to Tic Tac Toe!");

        while (true) {
            System.out.println("Enter the row and column for player X:");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            board[row][col] = 'X';
            moveCount++;

            printBoard();
            if (isWinning('X')) {
                System.out.println("Player X wins!");
                xWinCount++;
                break;
            }

            System.out.println("Enter the row and column for player O:");
            row = scanner.nextInt();
            col = scanner.nextInt();
            board[row][col] = 'O';
            moveCount++;

            printBoard();
            if (isWinning('O')) {
                System.out.println("Player O wins!");
                oWinCount++;
                break;
            }
        }

        System.out.println("Game Stats:");
        System.out.println("X Wins: " + xWinCount);
        System.out.println("O Wins: " + oWinCount);
        System.out.println("Total Moves: " + moveCount);
    }

    static void printBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isWinning(char player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }
}
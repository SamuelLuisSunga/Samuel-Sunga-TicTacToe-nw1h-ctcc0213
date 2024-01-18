package tictactoe;

/**
 *
 * @Samuel Luis  A. Sunga
 */
import java.util.Scanner;

public class TicTacToe {

    private final char[][] board;
    private char currentPlayer;

    // Constructor for initializing the game
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';

        // Set up the board, fill with spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Method to print the current state of the board
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Method to make a move for the current player
    public boolean makeMove(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ') {
            System.out.println("Invalid move. Try again.");
            return false;
        }

        board[row][col] = currentPlayer;
        return true;
    }

    // Method to check if there is a winner
    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // Row win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // Main diagonal win
        }
        return board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer;
    }

    // Method to check if the board is full
    public boolean isBoardFull() {
        // Check if the board is full (no empty spaces)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Board is not full
                }
            }
        }
        return true; // Board is full
    }

    // Method to switch the current player
    public void switchPlayer() {
        // Switch the current player after each move
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    // Main method where the program execution begins
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);

        // Game loop, continues until there is a winner or the board is full
        while (true) {
            game.printBoard();

            System.out.println("Player " + game.currentPlayer + "'s turn");
            System.out.print("Enter row (0-2): ");
            int row = scanner.nextInt();

            System.out.print("Enter column (0-2): ");
            int col = scanner.nextInt();

            if (game.makeMove(row, col)) {
                if (game.checkWin()) {
                    game.printBoard();
                    System.out.println("Player " + game.currentPlayer + " wins!");
                    break;
                } else if (game.isBoardFull()) {
                    game.printBoard();
                    System.out.println("It's a draw!");
                    break;
                } else {
                    game.switchPlayer();
                }
            }
        }

        scanner.close();
    }
}

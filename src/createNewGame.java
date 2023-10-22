import java.util.Random;
import java.util.Scanner;

public class createNewGame
{
        public static char[][] BLOCKS = new char[3][3];
        public static int[] SCORES = new int[2]; // Index 0 for player X, Index 1 for player O
        public static char CURRENT_PLAYER;

        public createNewGame() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    BLOCKS[i][j] = ' ';
                }
            }
            CURRENT_PLAYER = new Random().nextBoolean() ? 'X' : 'O'; // Randomly choosing the first player
        }

        public static void displayBoard () {
            System.out.println("    A   B   C ");
            System.out.println("  +---+---+---+");
            for (int i = 0; i < 3; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < 3; j++) {
                    System.out.print("| " + BLOCKS[i][j] + " ");
                }
                System.out.println("|");
                System.out.println("  +---+---+---+");
            }
        }

        public static void playGame () {
            Scanner scanner = new Scanner(System.in);
            boolean gameWon = false;
            int totalMoves = 0;

            while (!gameWon && totalMoves < 9) {
                System.out.print("Player " + CURRENT_PLAYER + ", enter your move (e.g., A1): ");
                String move = scanner.next();
                if (handleChoice(move)) {
                    displayBoard();
                    gameWon = checkVictory();
                    if (!gameWon) {
                        totalMoves++;
                        CURRENT_PLAYER = (CURRENT_PLAYER == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }
        }

        public static boolean handleChoice (String choice){
            int row = Integer.parseInt(choice.substring(1)) - 1;
            int col = switch (choice.toUpperCase().charAt(0)) {
                case 'A' -> 0;
                case 'B' -> 1;
                case 'C' -> 2;
                default -> -1;
            };
            if (row >= 0 && row < 3 && col >= 0 && BLOCKS[row][col] == ' ') {
                BLOCKS[row][col] = CURRENT_PLAYER;
                return true;
            }
            return false;
        }

        public static boolean checkVictory () {
            for (int i = 0; i < 3; i++) {
                if ((BLOCKS[i][0] == CURRENT_PLAYER && BLOCKS[i][1] == CURRENT_PLAYER && BLOCKS[i][2] == CURRENT_PLAYER) ||
                        (BLOCKS[0][i] == CURRENT_PLAYER && BLOCKS[1][i] == CURRENT_PLAYER && BLOCKS[2][i] == CURRENT_PLAYER)) {
                    return true;
                }
            }
            return (BLOCKS[0][0] == CURRENT_PLAYER && BLOCKS[1][1] == CURRENT_PLAYER && BLOCKS[2][2] == CURRENT_PLAYER) ||
                    (BLOCKS[0][2] == CURRENT_PLAYER && BLOCKS[1][1] == CURRENT_PLAYER && BLOCKS[2][0] == CURRENT_PLAYER);
        }

        public static void showResults () {
            if (checkVictory()) {
                System.out.println("Player " + CURRENT_PLAYER + " wins!");
                if (CURRENT_PLAYER == 'X') SCORES[0]++;
                else SCORES[1]++;
            } else {
                System.out.println("It's a draw!");
            }
            System.out.println("Score: X - " + SCORES[0] + ", O - " + SCORES[1]);
            System.out.print("Do you want to play again? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            Main.KEEP_PLAYING = scanner.next().toUpperCase().charAt(0) == 'Y';
        }
    }
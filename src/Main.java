import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        boolean KEEP_PLAYING = true;
        while (true) {
            new createNewGame();
            createNewGame.displayBoard();
            createNewGame.playGame();
            createNewGame.showResults();
        }
    }
}
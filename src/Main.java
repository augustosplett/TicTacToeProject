
public class Main {
    public static boolean KEEP_PLAYING = true;
    public static void main(String[] args)
    {

        while (KEEP_PLAYING) {
            new createNewGame();
            createNewGame.displayBoard();
            createNewGame.playGame();
            createNewGame.showResults();
        }
    }
}
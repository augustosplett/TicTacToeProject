import Block.Block;
import Block.State.Blank;
import Block.State.SimbolX;

public class Main {
    public static void main(String[] args) {

        createNewGame();
        displayBoard();

    }

    public static Block[][] BLOCKS = new Block[3][3];
    public static void displayBoard(){
        System.out.println("Hello world!");
        System.out.println("    +---+---+---+");
        System.out.println("    | A | B | C |");
        System.out.println("+---+---+---+---+");
        System.out.println("| 1 | " + BLOCKS[0][0].getState().display()
                + " | " + BLOCKS[0][1].getState().display()
                + " | " + BLOCKS[0][2].getState().display() + " |");
        System.out.println("+---+---+---+---+");
        System.out.println("| 2 | " + BLOCKS[1][0].getState().display()
                + " | " + BLOCKS[1][1].getState().display()
                + " | " + BLOCKS[1][2].getState().display() + " |");
        System.out.println("+---+---+---+---+");
        System.out.println("| 3 | " + BLOCKS[2][0].getState().display()
                + " | " + BLOCKS[2][1].getState().display()
                + " | " + BLOCKS[2][2].getState().display() + " |");
        System.out.println("+---+---+---+---+");
    }

    public static void createNewGame(){
        for(byte i = 0; i < 3; i++){
            for(byte j = 0; j < 3; j ++){
                BLOCKS[i][j] = new Block(Blank.instance());
            }
        }
    }
}
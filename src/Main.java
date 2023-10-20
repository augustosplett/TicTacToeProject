import Block.Block;
import Block.State.Blank;
import Block.State.SimbolX;
import java.util.Scanner;

//TODO 1:
//Implement/improve the function handleChoice to mark X or O according to the turn

//TODO 2:
//Implement the function to validate if some of the users won the game after every turn (change KEEP_PLAYING = false)

//TODO 3:
//Implement a function to get the name of the player one and Player 2

//TODO 4:
//Implement a function to show the winner right after he/she won the match

//TODO 5:
//Implement a factory to remove the static methods from the main file

//TODO 6:
//Implement/improve the function that receive the user input to accept "A1" and/or "1A"


public class Main {
    public static boolean KEEP_PLAYING = true;
    public static void main(String[] args) {
        createNewGame();
        while(KEEP_PLAYING){
            displayBoard();
            captureChoice();
        }

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
    public static void captureChoice(){
        var scanner = new Scanner(System.in);
        System.out.print("Insert the cell you want: ");
        var choice = scanner.next();
        handleChoice(choice);
    }
    public static void handleChoice(String choice){
        switch (choice.toUpperCase()){
            case "A1":
                BLOCKS[0][0].setState(SimbolX.instance());
                break;
            case "A2":
                BLOCKS[1][0].setState(SimbolX.instance());
                break;
            case "A3":
                BLOCKS[2][0].setState(SimbolX.instance());
                break;
            case "B1":
                BLOCKS[0][1].setState(SimbolX.instance());
                break;
            case "B2":
                BLOCKS[1][1].setState(SimbolX.instance());
                break;
            case "B3":
                BLOCKS[2][1].setState(SimbolX.instance());
                break;
            case "C1":
                BLOCKS[0][2].setState(SimbolX.instance());
                break;
            case "C2":
                BLOCKS[1][2].setState(SimbolX.instance());
                break;
            case "C3":
                BLOCKS[2][2].setState(SimbolX.instance());
                break;
        }
    }
}
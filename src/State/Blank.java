package State;

public class Blank implements IState{
    public static final Blank instance = new Blank();

    public static Blank instance() {return instance;}

    @Override
    public char display(){
        return ' ';
    }
}

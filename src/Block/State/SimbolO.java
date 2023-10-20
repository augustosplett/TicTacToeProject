package Block.State;

public class SimbolO implements IState{
    public static final SimbolO instance = new SimbolO();

    public static SimbolO instance() {return instance;}

    @Override
    public char display(){
        return 'O';
    }
}

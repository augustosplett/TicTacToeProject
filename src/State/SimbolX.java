package State;

public class SimbolX implements IState{
    public static final SimbolX instance = new SimbolX();

    public static SimbolX instance() {return instance;}

    @Override
    public char display(){
        return 'X';
    }
}


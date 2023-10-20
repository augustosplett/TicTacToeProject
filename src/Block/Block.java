package Block;

import Block.State.IState;

public class Block {
    private IState state;

    public Block(IState iState) {
        this.state = iState;
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }
}

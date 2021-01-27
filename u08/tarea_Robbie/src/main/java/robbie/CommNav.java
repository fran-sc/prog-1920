package robbie;

public abstract class CommNav implements IComm {
    protected Robbie robot;
    
    public CommNav(Robbie robot) { this.robot = robot; }

    public abstract void undo();
}
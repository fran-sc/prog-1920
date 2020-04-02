package robbie;

public class CommRot extends CommNav {
    private double angulo;
    
    public CommRot(Robbie robot, double angulo) {
        super(robot);
        this.angulo = angulo;
    }

    public void execute() { this.rotate(1); }

    public void undo() { this.rotate(-1); }

    public void rotate(int dir) {
        double new_rumbo;
        
        new_rumbo = this.robot.getRumbo() + dir*this.angulo;

        // Normalizamos al rango [0, 359]
        new_rumbo %= 359;   
        if(new_rumbo<0) new_rumbo += 360;
        
        this.robot.setRumbo(new_rumbo % 360);

        System.out.printf("Establecido nuevo rumbo > R: %.2f%n", this.robot.getRumbo());
    }
}
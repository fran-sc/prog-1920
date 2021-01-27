package robbie;

public class CommMove extends CommNav {
    private final double DegToRad = 2*Math.PI/360.0;
    private double dist;
    
    public CommMove(Robbie robot, double dist) {
        super(robot);
        this.dist = dist;
    }

    public void execute() { this.move(1); }

    public void undo() { this.move(-1); }

    public void move(int dir) {
        double new_x = this.dist * Math.sin(this.robot.getRumbo()*DegToRad);
        double new_y = this.dist * Math.cos(this.robot.getRumbo()*DegToRad);

        this.robot.setX(this.robot.getX() + dir*new_x);
        this.robot.setY(this.robot.getY() + dir*new_y);

        System.out.printf("Establecida nueva posición > (X: %.2f; Y: %.2f)%n", this.robot.getX(), this.robot.getY());
    }
}
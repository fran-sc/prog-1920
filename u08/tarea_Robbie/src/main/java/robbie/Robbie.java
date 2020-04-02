package robbie;

public class Robbie {
    public static final int RUMBO_MAX = 360;
    
    private double x;
    private double y;
    private double rumbo;

    public double getX() { return this.x; }
    public void setX(double x) { this.x = x; }

    public double getY() { return this.y; }
    public void setY(double y) { this.y = y; }

    public double getRumbo() { return this.rumbo; }
    public void setRumbo(double rumbo) { this.rumbo = rumbo%RUMBO_MAX; }

    public String toString() {
        return String.format("[(X: %.2f; Y: %.2f) R: %.2fº]", this.x, this.y, this.rumbo);
    }
}
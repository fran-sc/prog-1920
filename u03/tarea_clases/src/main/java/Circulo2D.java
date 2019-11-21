package geom;

public class Circulo2D {
    private static int _id = 0;
    private String id;
    private int cx;
    private int cy;
    private String color;
    private double radio;
    private boolean relleno;

    public Circulo2D(double radio) { this(radio, 0, 0); }

    public Circulo2D(double radio, int cx, int cy) {
        this.id = "Circulo2D#" + (++_id);
        this.radio = radio;
        this.cx = cx;
        this.cy = cy;
        this.color = "black";
        this.relleno = false;   // opcional
    }

    public String getID() { return id; }
    public double getRadio() { return radio; }
    public int getX() { return cx; }
    public int getY() { return cy; }
    public boolean getRelleno() { return relleno; }
    public String getColor() { return color; }

    public void setRadio(double radio) { this.radio = radio; }
    public void setRelleno(boolean relleno) { this.relleno = relleno; }
    public void setColor(String color) { this.color = color; }

    public void mover(int x, int y) { this.cx = x; this.cy = y; }

    public double getDistancia(Circulo2D c) { return getDistancia(this, c); }
    public static double getDistancia(Circulo2D c1, Circulo2D c2) {
        return Math.sqrt(Math.pow((c2.getX()-c1.getX()),2) + Math.pow((c2.getY()-c1.getY()),2));
    }

    @Override
    public String toString() { return "<" + id + ">:[ " + cx + ", " + cy + "; " + radio + " ]"; }
}
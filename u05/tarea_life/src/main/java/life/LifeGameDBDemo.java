package life;

public class LifeGameDBDemo {
    public static void main(String[] args) {
        LifeGameDB life1 = new LifeGameDB(new int[][]{ 
            {0,1,0,0,0,0,0},
            {0,0,1,0,1,1,0},
            {0,0,0,0,0,0,1},
            {0,1,0,0,1,0,1},
            {0,1,0,0,0,0,0},
            {0,0,0,0,1,0,1},
            {1,0,0,1,1,0,0}
        });

        System.out.println("\nGen: " + life1.getGen());
        System.out.println("Vivas: " + life1.getNcells());
        life1.printMatrix('X', '.');

        life1.evolve(1);

        System.out.println("\nGen: " + life1.getGen());
        System.out.println("Vivas: " + life1.getNcells());
        life1.printMatrix('X', '.');     

        LifeGameDB life2 = new LifeGameDB(4, 5, 8, 1);

        System.out.println("\nGen: " + life2.getGen());
        System.out.println("C.Vivas: " + life2.getNcells());
        life2.printMatrix('X', '.');
        
        life2.evolve(3);
        
        System.out.println("\nGen: " + life2.getGen());
        System.out.println("C.Vivas: " + life2.getNcells());
        life2.printMatrix('X', '.');             
    }
}
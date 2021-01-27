package life;

public class LifeGameDemo {
    public static void main(String[] args) {
        LifeGame life1 = new LifeGame(new int[][]{ 
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

        LifeGame life2 = new LifeGame(4, 5, 8, 1);

        System.out.println("\nGen: " + life2.getGen());
        System.out.println("C.Vivas: " + life2.getNcells());
        life2.printMatrix('X', '.');
        
        life2.evolve(3);
        
        System.out.println("\nGen: " + life2.getGen());
        System.out.println("C.Vivas: " + life2.getNcells());
        life2.printMatrix('X', '.');        
    }
}
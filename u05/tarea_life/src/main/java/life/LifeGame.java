package life;

import java.util.Random;
import java.util.Arrays;
import life.LifeGame;

/**
 * Autómata celular del "Juego de la Vida" de Conway
 */
public class LifeGame {
    private boolean[][] matrix;
    private int rows;
    private int cols;
    private int ncells;
    private int gen;
    
    public int getGen() { return this.gen; }

    public int getNcells() { return this.ncells; }

    public LifeGame(int rows, int cols, int ncells) { initLife(rows, cols, ncells, new Random()); }
    public LifeGame(int rows, int cols, int ncells, long seed) { initLife(rows, cols, ncells, new Random(seed)); }
    public LifeGame(int[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.gen = 1;

        this.matrix = new boolean[this.rows][this.cols];
        for(int i=0; i<this.rows; i++)
            for(int j=0; j<this.cols; j++) 
                if(data[i][j]==1) { 
                    this.matrix[i][j] = true;
                    ncells++;
                }
    }

    /**
     * Inicializa la matriz de celdas
     */
    private void initLife(int rows, int cols, int ncells, Random r) {
        this.rows = rows;
        this.cols = cols;
        this.ncells = ncells;
        this.gen = 1;
        this.matrix = new boolean[rows][cols];
        
        int pos, row , col;
        while(ncells>0) {
            pos = r.nextInt(rows*cols);
            row = pos/cols;
            col = pos%cols;

            // No puede colocarse una célula viva sobre una celda ocupada
            if(!matrix[row][col]) {
                matrix[row][col] = true;
                ncells--;
            }
        }
    }   

    /**
     * Copia de la matriz de datos.
     */
    public int[][] getMatrix() {
        int[][] data = new int[this.matrix.length][this.matrix[0].length];
        for(int i=0; i<this.rows; i++) 
            for(int j=0; j<this.cols; j++) 
                data[i][j] = (this.matrix[i][j])?1:0;
        return data;
    }

    /**
     * Imprime en la consola la matriz de datos.
     */
    public void printMatrix(char alive, char dead) {
        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.cols; j++) 
                System.out.print(this.matrix[i][j]?alive:dead);
            System.out.println();
        }
    }

    /**
     * Evoluciona las células de la matriz el número de generaciones indicado.
     */
    public void evolve(int ngen) {
        boolean[][] clone = new boolean[this.rows][this.cols]; // matriz para las copias

        while(ngen-->0) {
            int ncells = 0; // número de células tras la evolución
            for(int i=0; i<this.rows; i++) 
                for(int j=0; j<this.cols; j++) 
                    if(clone[i][j] = checkAlive(i, j)) ncells++;
            
            // Almacenamos la nueva generación
            for(int i=0; i<this.rows; i++) 
                this.matrix[i] = Arrays.copyOf(clone[i], this.cols);
            this.gen++;
            this.ncells = ncells;
        }        
    }

    /**
     * Determina si la celda va a tener una célula viva o no.
     */
    private boolean checkAlive(int row, int col) {
        boolean alive = this.matrix[row][col]; // estado actual de la celda

        // Obtiene el número de células vecinas vivas
        int aliveNeighbours = 0;
        int rowIni = (row>0)?(row-1):row;
        int rowEnd = (row<(this.rows-1))?(row+1):row;
        int colIni = (col>0)?(col-1):col;
        int colEnd = (col<(this.cols-1))?(col+1):col;
        for(int i=rowIni; i<=rowEnd; i++)
            for(int j=colIni; j<=colEnd; j++)
                if(i!=row || j!=col)
                    if(this.matrix[i][j]) aliveNeighbours++;

        if(alive) {
            // Si hay una célula viva y tiene dos o tres vecinas vivas sigue viva; si no, muere
            alive = (aliveNeighbours==2 || aliveNeighbours==3)?true:false;
        }
        else {
            // Si no hay una célula viva en la celda y tiene tres vecinas vivas, renace; si no, sigue muerta
            alive = (aliveNeighbours==3)?true:false;
        }
        return alive;
    }    

    public static void main(String[] args) {
        LifeGame life = new LifeGame(4, 5, 8, 1);

        System.out.println("\nGen: " + life.getGen());
        System.out.println("C.Vivas: " + life.getNcells());
        life.printMatrix('X', '.');
        
        life.evolve(3);
        System.out.println("\nGen: " + life.getGen());
        System.out.println("C.Vivas: " + life.getNcells());
        life.printMatrix('X', '.');

        LifeGame life2 = new LifeGame(new int[][]{ 
            {0,1,0,0,0,0,0},
            {0,0,1,0,1,1,0},
            {0,0,0,0,0,0,1},
            {0,1,0,0,1,0,1},
            {0,1,0,0,0,0,0},
            {0,0,0,0,1,0,1},
            {1,0,0,1,1,0,0}
        });

        System.out.println("\nGen: " + life2.getGen());
        System.out.println("Vivas: " + life2.getNcells());
        life2.printMatrix('X', '.');

        life2.evolve(0);
        System.out.println("\nGen: " + life2.getGen());
        System.out.println("Vivas: " + life2.getNcells());
        life2.printMatrix('X', '.');     
        
        int[][] testData = { {0,0,0,0,1},
                             {1,1,1,1,0},
                             {0,0,0,1,1},        
                             {0,0,0,1,0}};
        life = new LifeGame(testData);
        life.printMatrix('X', '.');
        life.evolve(3);
        life.printMatrix('X', '.');        
    }
}
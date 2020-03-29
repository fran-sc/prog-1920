package life;

import java.util.Random;
import java.util.Arrays;

/**
 * Autómata celular del "Juego de la Vida" de Conway
 * Versión con Doble Buffer
 */
public class LifeGameDB {
    private boolean[][][] buffer = new boolean[2][][];
    private boolean[][] currentBuffer;
    private boolean[][] nextBuffer;
    private int rows;
    private int cols;
    private int ncells;
    private int gen;
    
    public int getGen() { return this.gen; }

    public int getNcells() { return this.ncells; }

    public LifeGameDB(int rows, int cols, int ncells) { initLife(rows, cols, ncells, new Random()); }
    
    public LifeGameDB(int rows, int cols, int ncells, long seed) { initLife(rows, cols, ncells, new Random(seed)); }
    
    public LifeGameDB(int[][] data) {
        // Inicializa los buffers
        initBuffers(data.length, data[0].length);
        
        this.ncells = 0;
        this.gen = 1;

        // Carga los datos
        for(int i=0; i<this.rows; i++)
            for(int j=0; j<this.cols; j++) 
                if(data[i][j]==1) { 
                    this.currentBuffer[i][j] = true;
                    this.ncells++;
                }
    }

    /**
     * Inicializa los buffers
     */
    private void initBuffers(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        
        // Crea los dos buffers e inicializa los punteros
        this.buffer[0] = new boolean[this.rows][this.cols];
        this.buffer[1] = new boolean[this.rows][this.cols];
        this.currentBuffer = buffer[0];
        this.nextBuffer = buffer[1];
    }

    /**
     * Inicializa los buffers
     */
    private void clearBuffer(boolean[][] matrix) {
        for(boolean[] ar: matrix)
            Arrays.fill(ar, false);
    }

    /**
     * Intercambia los buffers
     */
    private void swapBuffers() {
        boolean[][] temp = this.currentBuffer;
        this.currentBuffer = this.nextBuffer;
        this.nextBuffer = temp;
    }

    /**
     * Inicializa la matriz de celdas
     */
    private void initLife(int rows, int cols, int ncells, Random r) {
        // Inicializa los buffers
        initBuffers(rows, cols);

        this.ncells = ncells;
        this.gen = 1;
        
        int row , col;
        int pos, rint, temp;

        // lista de posiciones posibles
        int[] nums = new int[rows*cols];
        for(pos=0; pos<nums.length; pos++) nums[pos] = pos;

        // Extraemos posiciones al azar (Fisher-Yates shuffle algorithm)            
        while(ncells-->0 && --pos>0 ) {
            rint = r.nextInt(pos);
            temp = nums[pos];
            nums[pos] = nums[rint];
            nums[rint] = temp;
            
            row = nums[pos]/cols;
            col = nums[pos]%cols;
            this.currentBuffer[row][col] = true;
        }
    }   

    /**
     * Copia de la matriz de datos.
     */
    public int[][] getMatrix() {
        int[][] data = new int[this.currentBuffer.length][this.currentBuffer[0].length];

        for(int i=0; i<this.rows; i++) 
            for(int j=0; j<this.cols; j++) 
                data[i][j] = (this.currentBuffer[i][j])?1:0;
        
        return data;
    }

    /**
     * Imprime en la consola la matriz de datos.
     */
    public void printMatrix(char alive, char dead) {
        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.cols; j++) 
                System.out.print(this.currentBuffer[i][j]?alive:dead);
            System.out.println();
        }
    }

    /**
     * Evoluciona las células de la matriz el número de generaciones indicado.
     */
    public void evolve(int ngen) {
        clearBuffer(this.nextBuffer);

        while(ngen-->0) {
            int ncells = 0; // número de células tras la evolución
            for(int i=0; i<this.rows; i++) 
                for(int j=0; j<this.cols; j++) 
                    if(this.nextBuffer[i][j] = checkAlive(i, j)) ncells++;
            
            // Intercambiamos los buffers
            swapBuffers();

            this.gen++;
            this.ncells = ncells;
        }        
    }

    /**
     * Determina si la celda va a tener una célula viva o no.
     */
    private boolean checkAlive(int row, int col) {
        boolean alive = this.currentBuffer[row][col]; // estado actual de la celda

        // Obtiene el número de células vecinas vivas
        int aliveNeighbours = 0;
        int rowIni = (row>0)?(row-1):row;
        int rowEnd = (row<(this.rows-1))?(row+1):row;
        int colIni = (col>0)?(col-1):col;
        int colEnd = (col<(this.cols-1))?(col+1):col;
        for(int i=rowIni; i<=rowEnd; i++)
            for(int j=colIni; j<=colEnd; j++)
                if(i!=row || j!=col)
                    if(this.currentBuffer[i][j]) aliveNeighbours++;

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
}
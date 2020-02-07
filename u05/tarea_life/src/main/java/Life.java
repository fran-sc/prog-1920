import java.util.Arrays;
import java.util.Random;

public class Life {
    private boolean[][] cells;
    private int rows;
    private int cols;

    public Life(int size) { this(size, size); }

    public Life(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        cells = new boolean[rows][cols];

        randomInit();
    }

    private void randomInit() {
        Random r = new Random();

        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.cols; j++) {
                cells[i][j] = r.nextBoolean();
            }
        }
    }

    public void show(String on, String off) {
        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.cols; j++) {
                System.out.print((cells[i][j])?on:off);
            }
            System.out.println();
        }        
    }

    public void nextGen() {
        boolean[][] clone = new boolean[this.rows][];
        for(int i=0; i<this.rows; i++)
            clone[i] = Arrays.copyOf(cells[i], cols);

        for(int i=0; i<this.rows; i++) {
            for(int j=0; j<this.cols; j++) {
                clone[i][j] = checkAlive(i, j);
            }
        }        
        cells = clone;
    }

    private boolean checkAlive(int row, int col) {
        boolean alive = cells[row][col];

        // Get aliveNeighbours
        int aliveNeighbours = 0;
        int rowIni = (row>0)?(row-1):row;
        int rowEnd = (row<(this.rows-1)?(row+1):row);
        int colIni = (col>0)?(col-1):col;
        int colEnd = (col<(this.cols-1)?(col+1):col);
        for(int i=rowIni; i<=rowEnd; i++)
            for(int j=colIni; j<=colEnd; j++)
                if(i!=row || j!=col)
                    if(cells[i][j]) aliveNeighbours++;

        if(alive) {
            // If it's alive and has two or three alive neighbours -> keeps life; Otherwise -> die
            alive = (aliveNeighbours==2 || aliveNeighbours==3)?true:false;
        }
        else {
            // If it's dead end has three alive neighbours -> reborning; Otherwise -> keeps dead
            alive = (aliveNeighbours==3)?true:false;
        }

        return alive;
    }
}
import java.util.Scanner;

public class R432 {
    private static final char START = 'S';
    private static final char EXIT = 'F';
    private static final char FREE = '.';
    private static final char ASTEROID = '*';
    private static final char VISITED = 'V';

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String line;
        int rows, cols, init_row=0, init_col=0;
        char[][] board;

        while(cin.hasNext()) {
            rows = cin.nextInt();
            cols = cin.nextInt();
            cin.nextLine();

            // Tablero
            board = new char[rows][cols];
            for(int i=0;i<rows; i++) {
                line = cin.nextLine();
                for(int j=0; j<cols; j++) {
                    board[i][j] = line.charAt(j);
                    if(board[i][j] == START) {
                        init_row = i;
                        init_col = j;
                    }
                }
            }       

            System.out.println((checkPath(init_row, init_col, board))?"SI":"NO");
        }
    }

    private static boolean checkPath(int row, int col, char[][] board) {
        boolean path = false;

        char c = board[row][col];

        if(c==EXIT) return true;    // Es la salida
        if(c==ASTEROID || c==VISITED) return false;  // No transitable

        board[row][col] = VISITED;  // Marcamos la celda como visitada

        // Izquierda
        if(col>0) path = checkPath(row, col-1, board);

        // Abajo
        if(!path && row<board.length-1) path = checkPath(row+1, col, board);

        // Derecha
        if(!path && col<board[0].length-1) path = checkPath(row, col+1, board);

        // Arriba
        if(!path && row>0) path = checkPath(row-1, col, board);

        return path;
    }    
}
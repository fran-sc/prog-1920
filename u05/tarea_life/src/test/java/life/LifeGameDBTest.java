package life;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * TESTS
 * 
 * TEST  1: LifeGame(int[][] data)
 * TEST  2: LifeGame(int rows, int cols, int ncells, long seed)
 * TEST  3: LifeGame(int rows, int cols, int ncells)
 * TEST  4: printMatrix()
 * TEST  5: evolve(int ngen)
 */
public class LifeGameDBTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test 
    public void test_LifeGameDB_FromArray() {
        int[][] testData = {    {0,1,0,0,0,0,0},
                                {0,0,1,0,1,1,0},
                                {0,0,0,0,0,0,1},        
                                {0,1,0,0,1,0,1},        
                                {0,1,0,0,0,0,0},        
                                {0,0,0,0,1,0,1},      
                                {1,0,0,1,1,0,0}};

        LifeGameDB life = new LifeGameDB(testData);
        assertTrue(compareArray(life.getMatrix(), testData));
    }   

    @Test 
    public void test_LifeGameDB_WithSeed() {
        int[][] testData = { {0,0,0,0,0},
                             {0,0,0,0,0},
                             {0,1,1,0,1},        
                             {0,1,1,1,1}};

        LifeGameDB life = new LifeGameDB(4, 5, 8, 1);
        life.evolve(3);
        assertTrue(compareArray(life.getMatrix(), testData));
    }   

    @Test 
    public void test_LifeGameDB_NoSeed() {
        final int NCELLS = 8;
        LifeGameDB life = new LifeGameDB(4, 5, NCELLS);
        assertEquals(NCELLS, life.getNcells());
    }  

    @Test 
    public void test_printMatrix() {
        int[][] testData = { {0,0,0,0,0},
                             {1,1,1,0,0},
                             {0,0,0,1,1},        
                             {0,0,0,1,1}};
        String expectedOutput = ".....\n" +
                                "XXX..\n" + 
                                "...XX\n" + 
                                "...XX";

        LifeGameDB life = new LifeGameDB(testData);
        life.printMatrix('X','.');
        assertEquals(expectedOutput, outContent.toString().trim());
    }  

    @Test 
    public void test_evolve() {
        final int NGEN = 3;
        int[][] testData = { {0,0,0,0,1},
                             {1,1,1,1,0},
                             {0,0,0,1,1},        
                             {0,0,0,1,0}};
        int[][] expectedOutput = {  {0,0,0,0,0},
                                    {1,1,1,0,0},
                                    {0,0,0,1,1},        
                                    {0,0,0,1,1}};

        LifeGameDB life = new LifeGameDB(testData);
        life.evolve(NGEN);
        assertTrue(compareArray(life.getMatrix(), expectedOutput));
    }  
    
    private boolean compareArray(int[][] a1, int[][] a2) {
        for(int i=0; i<a1.length; i++)
            for(int j=0; j<a1[0].length; j++)
                if(a1[i][j] != a2[i][j]) return false;
        return true;
    }

}
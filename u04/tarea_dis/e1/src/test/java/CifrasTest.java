import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.junit.*;

public class CifrasTest {
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
    public void eval_getCifras_sin_numeros() {
        String data = "holaqué tal?bien FIN 55";
        int cifras = Cifras.getCifras(data);
        try {
            assertEquals(0, cifras);
            restoreStreams();
            System.out.println("test1: OK");
        }
        catch(AssertionError e) {
            restoreStreams();
            System.out.println("test1: failed!");
        }
    }

    @Test
    public void eval_getCifras_con_numeros() {
        String data = "hola 55qué 99tal?bien FIN 55";
        int cifras = Cifras.getCifras(data);
        try{
            assertEquals(2, cifras);        
            assertEquals("55\n99\nEl número mayor de los encontrados es: 99\n", 
                                                                outContent.toString()); 
            restoreStreams();                   
            System.out.println("test2: OK");                                             
        }
        catch(AssertionError e) {
            restoreStreams();
            System.out.println("test2: failed!");
        }       
    }    
}

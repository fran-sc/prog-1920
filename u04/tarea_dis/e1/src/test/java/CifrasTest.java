import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import org.unit.Test;

class CifrasTest {
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
        String dsata = "hola\nqué tal?\nbien FIN 55\n66";
        int cifras = Cifras.getCifras(data);
        assertEquals(-1, cifras);
    }

    @Test
    public void eval_getCifras_con_numeros() {
        String dsata = "hola 55\nqué 99tal?\nbien FIN 55\n66";
        int cifras = Cifras.getCifras(data);
        assertEquals(2, cifras);        
        assertEquals("El número mayor de los encontrados es: 99", outContent);        
    }    
}
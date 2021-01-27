public class DibujaTriang {
    public static void dibujaTriang(int n, char c) {
        if(n==0 || Math.abs(n)>9) 
            System.out.println("Entrada no válida");
        else if(n>0) 
            dibujaTriangNorm(n, c);
        else 
            dibujaTriangInv(n*-1, c);
    }

    private static void dibujaTriangNorm(int n, char c) {
        // primera línea
        for(int i=1; i<n; i++)
            System.out.print(" ");
        System.out.println(c);
        // líneas centrales
        for(int i=2; i<n; i++) {
            for(int j=0; j<n-i; j++)
                System.out.print(" ");
            System.out.print(c);
            for(int j=0; j<2*(i-1)-1; j++)
                System.out.print(" ");
            System.out.println(c);
        }
        // última línea
        for(int i=0; i<2*n-1; i++)
            System.out.print(c);
        System.out.println();    
    }

    private static void dibujaTriangInv(int n, char c) {
        // última línea
        for(int i=0; i<2*n-1; i++)
            System.out.print(c);        
        System.out.println();
        // líneas centrales
        for(int i=n-1; i>1; i--) {
            for(int j=0; j<n-i; j++)
                System.out.print(" ");
            System.out.print(c);
            for(int j=0; j<2*(i-1)-1; j++)
                System.out.print(" ");
            System.out.println(c);
        }            
        // primera línea
        for(int i=1; i<n; i++)
            System.out.print(" ");
        System.out.println(c);            
    }

    public static void main(String[] args) {
       DibujaTriang.dibujaTriang(5, '#');
       DibujaTriang.dibujaTriang(-3, '@');
       DibujaTriang.dibujaTriang(0, '#');
    }
}

public class C2 {
    public static void main(String[] args) {
        System.out.println("************************");
        System.out.println("* TABLA DE MULTIPLICAR *");
        System.out.println("************************\n");
        
        for(int n=0; n<=10; n++) {
            System.out.println("--------------");
            System.out.println(" TABLA DEL " + n);
            System.out.println("--------------");
            for(int i=0; i<=10; i++) {
                System.out.println(" " + n + " x " + i + " = " + (n*i));
            }
        }
    }        
}

import java.util.Scanner;

public class LifeGame {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        // Init world
        System.out.print("Size? ");
        Life lf = new Life(cin.nextInt());
        cin.nextLine();

        do {
            lf.show("##", "  ");
            //System.out.print("Next gen?");
            cin.nextLine();
            lf.nextGen();
        } while(true);
    }
}
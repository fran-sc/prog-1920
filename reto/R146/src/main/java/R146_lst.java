import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

public class R146_lst {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int num, n, i, j;
        
        ArrayList<Integer> lista = new ArrayList<>();
        ArrayList<Integer> listab = new ArrayList<>();

        num=cin.nextInt();
        while(num!=0){
            lista.clear();
            for(i=1; i<=num; ++i) lista.add(i);

            j=1;
            while(++j<=lista.size()) {
                listab.clear();
                n = (int)Math.ceil((double)lista.size()/j);
                for(i=0; i<n; i++)
                    listab.add(lista.get(j*i));
                lista.removeAll(listab);
            }

            System.out.print(num + ":");
            for(i=lista.size()-1; i>=0; --i)
                System.out.print(" " + lista.get(i));
            System.out.println();

            num = cin.nextInt();
        }
    }    
}
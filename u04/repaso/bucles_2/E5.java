import java.util.Scanner;

public class E5 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        while(true) {
            String input = cin.nextLine();
            if(input.equals("0"))
                break;
            
            String num = "";    // número resultante
            int c=1, d;         // acarreo y dígitos
            for(int i=input.length()-1; i>=0; i--) {
                char ch = input.charAt(i);
                if(ch=='.')
                    num = ch + num;
                else {
                    d = ch - '0';
                    if(c==1) {
                        // hay acarreo
                        d += 1;
                        c = (d==10)?1:0;
                    }
                    num = (d%10) + num;
                }
            }
            if(c==1) {
                // acarreo último dígito
                if((num.length()+1)%4==0)
                    num = '.' + num;
                num = '1' + num;    
            } 

            System.out.println(num);
        }
    }
}

public class Cifras {
    public static int getCifras(String data) {
        int cont = 0, max = -1, numVal;
        String strNum = "";
        boolean newNum = false;

        for(int i=0; i<data.length(); i++) {
            if(Character.isDigit(data.charAt(i))) {
                // inicia nuevo número
                newNum = true;

                // añade dígito
                strNum += data.charAt(i);
            }
            else if(newNum) {
                // valor del nuevo número
                numVal = Integer.parseInt(strNum);
                
                // actualiza el máximo
                if(numVal > max) 
                    max = numVal;
                
                // muestra el valor
                System.out.println(numVal);
                
                // incrementa contador
                cont++;

                // inicializa 
                strNum = "";
                newNum = false;
            }
        }
        // muestra el mayor
        if(max>-1)
            System.out.println("El número mayor de los encontrados es: " + max);

        return cont;
    }
}
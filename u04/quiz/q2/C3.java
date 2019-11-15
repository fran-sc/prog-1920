public static int esPrimo(int n) {
    if(n<1) return -1;
    if(n<4) return 1;
        
    boolean primo = true;
    for(int i=2; i<=n/2; i++) 
        if(n%i == 0){
            primo = false;
            break;
        }
    return (primo)?1:0;
}        

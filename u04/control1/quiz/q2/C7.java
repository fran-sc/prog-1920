public static String flipChar(String s) {
    final int MASK = 0b10_0000;
    
    String newLine = "";

    for(int i=0; i<s.length(); i++) {
        char c = s.charAt(i);
        if((c>='a' && c<='z') || (c>='A' && c<='Z')) { 
            c ^= MASK;
        }
        newLine += c;
    }

    return newLine;
}

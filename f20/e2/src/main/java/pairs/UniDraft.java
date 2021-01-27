package pairs;

import java.util.*;

public class UniDraft {
    public static boolean checkArguments(Map<String,List<String>> a, Map<String,List<String>> b) {
        boolean ret = true;

        if((a.size()==0 || b.size()==0) || (a.size()!=a.size()))
            ret = false;
        else {
            int n = a.size();
            for(String pref: a.keySet()) {
                if(a.get(pref).size() != n) {
                    ret = false;
                    break;
                }
            }
            if(ret) {
                for (String pref : b.keySet()) {
                    if (b.get(pref).size() != n) {
                        ret = false;
                        break;
                    }
                }
            }
        }

        return ret;
    }

    public static Map<String, String> asignaJugadores(Map<String,List<String>> a, Map<String,List<String>> b) {
        if(!checkArguments(a, b))
            throw new IllegalArgumentException("Número de valores no válido");

        Map<String, String> pairs = new TreeMap<String, String>();
        List<String> unmatch = new ArrayList<String>(b.keySet());

        int i = 0;
        while(unmatch.size()>0) {
            if (i >= unmatch.size()) i = 0;            
            
            // next B
            String b_key = unmatch.get(i);

            // next A to propose
            String b_next_a = b.get(b_key).get(0);

            // remove proposed A from list
            b.get(b_key).remove(0);

            // A has current match?
            String b_current = pairs.get(b_next_a);

            if(b_current==null) {  
                // it was free. Create new pair
                pairs.put(b_next_a, b_key);
                // remove from unmatch
                unmatch.remove(b_key);
            }
            else {
                // A prefers this one?
                List<String> a_pref = a.get(b_next_a);
                if(a_pref.indexOf(b_key)<a_pref.indexOf(b_current)) {
                    // change pair
                    pairs.put(b_next_a, b_key);
                    // remove from unmatch
                    unmatch.remove(b_key);
                    // add old one to unmatch
                    unmatch.add(b_current);
                }
                else {
                    // leave it in unmatch and pick next
                    ++i;
                }
            }
        }

        return pairs;
    }   

    public static void main(String[] args) {
        List<String> A_pref = new ArrayList<>(
            Arrays.asList("d", "c", "a", "b"));
        
        List<String> B_pref = new ArrayList<>(
            Arrays.asList("b", "d", "a", "c"));
        
        List<String> C_pref = new ArrayList<>(
            Arrays.asList("d", "a", "b", "c"));

        List<String> D_pref = new ArrayList<>(
            Arrays.asList("c", "b", "a", "d"));

        Map<String, List<String>> W_pref = new TreeMap<>();
        W_pref.put("A", A_pref);
        W_pref.put("B", B_pref);
        W_pref.put("C", C_pref);
        W_pref.put("D", D_pref);

        List<String> a_pref = new ArrayList<>(
            Arrays.asList("A", "B", "C", "D"));
        
        List<String> b_pref = new ArrayList<>(
            Arrays.asList("A", "D", "C", "B"));
        
        List<String> c_pref = new ArrayList<>(
            Arrays.asList("B", "A", "C", "D"));

        List<String> d_pref = new ArrayList<>(
            Arrays.asList("D", "B", "C", "A"));

        Map<String, List<String>> M_pref = new TreeMap<>();
        M_pref.put("a", a_pref);
        M_pref.put("b", b_pref);
        M_pref.put("c", c_pref);
        M_pref.put("d", d_pref);

        Map<String, String> pairs = asignaJugadores(W_pref, M_pref);

        for(String k: pairs.keySet()) {
            System.out.println(k + ": " + pairs.get(k));
        }

        // Caso de prueba 2
        List<String> NC_pref = new ArrayList<>(Arrays.asList("Jordan", "Bird", "Johnson"));
        List<String> Mi_pref = new ArrayList<>(Arrays.asList("Jordan", "Johnson", "Bird"));
        List<String> In_pref = new ArrayList<>(Arrays.asList("Bird", "Johnson", "Jordan"));
        
        Map<String, List<String>> uni_pref = new TreeMap<>();
        uni_pref.put("North Carolina", NC_pref);
        uni_pref.put("Michigan", Mi_pref);
        uni_pref.put("Indiana", In_pref);

        List<String> Jh_pref = new ArrayList<>(Arrays.asList("North Carolina", "Indiana", "Michigan"));
        List<String> Bi_pref = new ArrayList<>(Arrays.asList("Indiana", "Michigan", "North Carolina"));
        List<String> Jr_pref = new ArrayList<>(Arrays.asList("North Carolina", "Indiana", "Michigan"));
        
        Map<String, List<String>> ply_pref = new TreeMap<>();
        ply_pref.put("Johnson", Jh_pref);
        ply_pref.put("Bird", Bi_pref);
        ply_pref.put("Jordan", Jr_pref);

        pairs = asignaJugadores(uni_pref, ply_pref);

        for (String k : pairs.keySet()) {
            System.out.println(k + ": " + pairs.get(k));
        }

        try {
            UniDraft.asignaJugadores(new TreeMap<String, List<String>>(), new TreeMap<String, List<String>>());
        }
        catch(IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            a_pref.clear();
            UniDraft.asignaJugadores(W_pref, M_pref);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
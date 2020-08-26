import java.util.*;

public class Match {
    public static Map<String, String> match(Map<String,List<String>> a, Map<String,List<String>> b) {
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

        Map<String, String> pairs = match(W_pref, M_pref);

        for(String k: pairs.keySet()) {
            System.out.println(k + ": " + pairs.get(k));
        }
    }
}
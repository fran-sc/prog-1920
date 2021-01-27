
package ds;

public class DynArrayDemo {
    public static void main(String[] args) {
        DynArray<String> d1 = new DynArray<>(1);
        System.out.println("d1[" + d1.size() + "]: " + d1);
        d1.add("hi");
        d1.add("bye");
        System.out.println("d1[" + d1.size() + "]: " + d1);

        DynArray<Integer> d2 = new DynArray<>(new Integer[]{11, 12, 14});
        System.out.println("d2[" + d2.size() + "]: " + d2);

        DynArray<Integer> d3 = new DynArray<>(d2);
        System.out.println("d3[" + d3.size() + "]: " + d3);

        d2.add(2, 13);
        d3.clear();
        System.out.println("d2[" + d2.size() + "]: " + d2);
        System.out.println("d3[" + d3.size() + "]: " + d3);

        d1.set(0, "phone"); 
        d1.delete("bye");
        d1.add("home!");
        System.out.println("d1[" + d1.size() + "]: " + d1);
        
        for(int i=0; i<d2.size(); i++)
            System.out.println(d2.get(i));

        for(int n: d2)
            System.out.println(n);
    }
}
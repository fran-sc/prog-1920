package ds;

import java.util.Arrays;

import java.util.Iterator;

@SuppressWarnings("unchecked")

/**
 * La clase DynArray nos permite construir arrays dinámicos.
 */
public class DynArray<T> implements Iterable<T> {
    private static final int DEF_CAPACITY = 10; // Capacidad por defecto

    private T[] data;       // Array de elementos
    private int len;        // Ocupación actual

    /**
     * Construye un nuevo array con una capacidad inicial de diez elementos.
     */
    public DynArray() { this(DEF_CAPACITY); }

    /**
     * Construye un nuevo array con la capacidad inicial indicada.
     * 
     * @param capacity capacidad inicial del array
     */
    public DynArray(int capacity) {
        if(capacity<=0) throw new IllegalArgumentException("Tamaño no válido: " + capacity);

        this.len = 0;                       
        this.data = (T[]) new Object[capacity];
    }

    /**
     * Construye un nuevo array dinámico a partir del array suministrado. 
     * La capacidad inicial será la del array suministrado.
     * 
     * @param ar array de cadenas de caracteres a partir del cual se crea el array dinámico
     * @throws IllegalArgumentException si el argumento es null
     */
    public DynArray(T[] ar) {
        if(ar == null) throw new IllegalArgumentException("Argumento String[]: null");
        
        this.len = ar.length;

        // Copiamos los datos
        this.data = Arrays.copyOf(ar, this.len);        
    }

    /**
     * Construye un nuevo array dinámico a partir del array dinámico suministrado. 
     * La capacidad inicial será la del array suministrado.
     * 
     * @param ar array dinámico a partir del cual se crea
     * @throws IllegalArgumentException si el argumento es null
     */
    public DynArray(DynArray<T> ar) {
        if(ar == null) throw new IllegalArgumentException("Argumento DynStrArray: null");
        
        this.len = ar.len;
        
        // Copiamos los datos
        this.data = Arrays.copyOf(ar.data, ar.len);      
    }

    /**
     * Devuelve el número de elementos en el array.
     * 
     * @return número de elementos en el array
     */
    public int size() { return this.len; }

    /**
     * Devuelve si el array está vacío o no.
     * 
     * @return si el array está vacío o no
     */
    public boolean isEmpty() { return this.len==0; }

    /**
     * Vacía el array. Basta con poner la ocupación a 0. No necesitamos borrar los elementos pues no serán accesibles
     */
    public void clear() { this.len = 0; }

    /**
     * Devuelve el elemento de la posición indicada del array.
     * 
     * @param index índice del elemento a devolver
     * @return el elemento en la posición indicada en el array
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */
    public T get(int index) {
        if(index<0 || index>=this.len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        return this.data[index];
    }

    /**
     * Añade el nuevo elemento al final del array.
     * 
     * @param obj nuevo elemento que se añadirá al array
     */
    public void add(T obj) { this.add(this.len, obj); }

    /**
     * Inserta el nuevo elemento en la posición indicada.
     * 
     * @param index posición en la que se insertará el elemento
     * @param obj nuevo elemento que se añadirá al array
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index > size())
     */
    public void add(int index, T obj) { 
        if(index<0 || index>this.len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        // Si el array está lleno, incrementamos el espacio un 50%
        if(this.len == this.data.length) this.data = Arrays.copyOf(this.data, (int)(len*1.5 + 1));

        // desplazamos los elementos desde index para abrir "hueco" e insertar el nuevo elemento
        for (int i=len; i>index; i--) this.data[i] = this.data[i-1];

        this.data[index] = obj;  // inserción del nuevo elemento
        this.len++;                 // actualizamos la ocupación
    }

    /**
     * Actualiza la posición indicada con el nuevo valor suministrado.
     * 
     * @param index posición del array que se actualizará
     * @param obj nuevo elemento en la posición indicada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    public void set(int index, T obj) {
        if(index<0 || index>=this.len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        
        this.data[index] = obj;  // actualizamos el valor
    }

    /**
     * Elimina el valor en la posición indicada del array.
     * 
     * @param index posición del array que se borrará
     * @return el valor de la posición borrada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    public T remove(int index) {
        if(index<0 || index>=len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        T ret = this.data[index]; // valor borrado
        
        // mueve los elementos una posición a la izquierda desde index
        for(int i=index; i<this.len-1; i++) this.data[i] = this.data[i+1];  

        this.data[--this.len] = null; // limpia el último elemento movido y actualiza la ocupación
        
        return ret; // devuelve el valor borrado
    }

    /**
     * Elimina la primera ocurrencia del elemento si se encuentra en el array.
     * 
     * @param obj elemento que se quiere eliminar
     * @return si se encontró (y borró) la cadena buscada o no
     */
    public boolean delete(T obj) {
        // Buscamos el elemento
        int index = this.indexOf(obj);

        // Eliminamos el elemento
        if(index!=-1) this.remove(index);

        return (index!=-1);
    }

    /**
     * Devuelve la posición de la primera ocurrencia del elemento en el array.
     * 
     * @param obj cadena de caracteres que se quiere buscar
     * @return posición en el array de la cadena buscada o -1 si no se encuentra
     */    
    public int indexOf(T obj) {
        int index = -1;

        // Buscamos la primera ocurrencia del elemento
        for(int i=0; i<this.len; i++) 
            if(this.data[i].equals(obj)) { index = i; break; }

        return index;
    }

    @Override
    public String toString() {
        String ret = "[";

        for(int i=0; i<this.len; i++) ret += (i>0?", ":"") + data[i];

        return ret + "]";
    }

    @Override
    public Iterator<T> iterator() { 
        return new Iterator() {
            private int p = 0;
    
            @Override    
            public boolean hasNext() { return (p < len); }

            @Override    
            public T next() { return data[p++]; }
        };
    }

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
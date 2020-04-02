package ds;

import java.util.Arrays;

/**
 * La clase DynStrArray nos permite construir arrays dinámicos para almacenar listas de caracteres.
 */
public class DynStrArray {
    private static final int DEF_CAPACITY = 10; // Capacidad por defecto

    private String[] data;      // Array de elementos
    private int len;            // Ocupación actual

    /**
     * Construye un nuevo array con una capacidad inicial de diez elementos.
     */
    public DynStrArray() { this(DEF_CAPACITY); }

    /**
     * Construye un nuevo array con la capacidad inicial indicada.
     * 
     * @param capacity capacidad inicial del array
     */
    public DynStrArray(int capacity) {
        if(capacity<0) throw new IllegalArgumentException("Tamaño no válido: " + capacity);

        this.len = 0;
        this.data = new String[capacity];
    }

    /**
     * Construye un nuevo array dinámico a partir del array de cadenas suministrado. 
     * La capacidad inicial será la del array suministrado.
     * 
     * @param strArr array de cadenas de caracteres a partir del cual se crea el array dinámico
     * @throws IllegalArgumentException si el argumento es null
     */
    public DynStrArray(String[] strArr) {
        if(strArr == null) throw new IllegalArgumentException("Argumento String[]: null");
        
        this.len = strArr.length;

        // Copiamos los datos
        this.data = Arrays.copyOf(strArr, this.len);        
    }

    /**
     * Construye un nuevo array dinámico a partir del array dinámico suministrado. 
     * La capacidad inicial será la del array suministrado.
     * 
     * @param strArr array dinámico a partir del cual se crea
     * @throws IllegalArgumentException si el argumento es null
     */
    public DynStrArray(DynStrArray dynArr) {
        if(dynArr == null) throw new IllegalArgumentException("Argumento DynStrArray: null");
        
        this.len = dynArr.size();
        this.data = new String[this.len];
        
        // Copiamos los datos
        for(int i=0; i<this.len; i++) this.data[i] = dynArr.get(i);
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
    public String get(int index) {
        if(index<0 || index>=this.len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        return this.data[index];
    }

    /**
     * Añade el nuevo elemento al final del array.
     * 
     * @param cadena nuevo elemento que se añadirá al array
     */
    public void add(String cadena) { this.add(this.len, cadena); }

    /**
     * Inserta el nuevo elemento en la posición indicada.
     * 
     * @param index posición en la que se insertará el elemento
     * @param cadena nuevo elemento que se añadirá al array
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index > size())
     */
    public void add(int index, String cadena) { 
        if(index<0 || index>this.len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        // Si el array está lleno, incrementamos el espacio
        if(this.len == this.data.length) this.resize();

        // desplazamos los elementos desde index para abrir "hueco" e insertar el nuevo elemento
        for (int i=len; i>index; i--) this.data[i] = this.data[i-1];

        this.data[index] = cadena;  // inserción del nuevo elemento
        this.len++;                 // actualizamos la ocupación
    }

    /**
     * Actualiza la posición indicada con el nuevo valor suministrado.
     * 
     * @param index posición del array que se actualizará
     * @param cadena nuevo elemento en la posición indicada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    public void set(int index, String cadena) {
        if(index<0 || index>=this.len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        
        this.data[index] = cadena;  // actualizamos el valor
    }

    /**
     * Elimina el valor en la posición indicada del array.
     * 
     * @param index posición del array que se borrará
     * @return el valor de la posición borrada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    public String remove(int index) {
        if(index<0 || index>=len) throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        String ret = this.data[index]; // valor borrado
        
        // mueve los elementos una posición a la izquierda desde index
        for(int i=index; i<this.len-1; i++) this.data[i] = this.data[i+1];  

        this.data[--this.len] = null; // limpia el último elemento movido y actualiza la ocupación
        
        return ret; // devuelve el valor borrado
    }

    /**
     * Elimina la primera ocurrencia de la cadena indicada si se encuentra en el array.
     * 
     * @param cadena cadena de caracteres que se quiere eliminar
     * @return si se encontró (y borró) la cadena buscada o no
     */
    public boolean delete(String cadena) {
        // Buscamos el elemento
        int index = this.indexOf(cadena);

        // Eliminamos el elemento
        if(index!=-1) this.remove(index);

        return (index!=-1);
    }

    /**
     * Devuelve la posición de la primera ocurrencia de la cadena en el array.
     * 
     * @param cadena cadena de caracteres que se quiere buscar
     * @return posición en el array de la cadena buscada o -1 si no se encuentra
     */    
    int indexOf(String cadena) {
        int index = -1;

        // Buscamos la primera ocurrencia del elemento
        for(int i=0; i<this.len; i++) 
            if(this.data[i].equals(cadena)) { index = i; break; }

        return index;
    }

    @Override
    public String toString() {
        String ret = "[ ";

        for(int i=0; i<this.len; i++) ret += (i>0?", ":"") + data[i];

        return ret + " ]";
    }

    // Redimensiona el array un 50% más
    private void resize() {
        String[] temp = new String[(int)(len*1.5)];           // nuevo array

        for(int i=0; i<len; i++) temp[i] = this.data[i];    // copiamos los datos

        this.data = temp;                                   // swap;
    }
}

package ds;
import java.util.Iterator;

/**
 * La clase ListNode representa los elementos de la lista enlazada.
 * 
 * @author David Bowman <dbowman2001 @ hal9000>
 * @version 1.0
 */
class ListNode<T> {
    private T data;             // valor del elemento
    private ListNode<T> next;   // puntero al siguiente elemento
    private ListNode<T> prev;   // puntero al elemento anterior

    ListNode(final T obj) { data = (T) obj; }

    public void setNext(final ListNode<T> node) { this.next = node; }

    public void setPrev(final ListNode<T> node) { this.prev = node; }

    public ListNode<T> getNext() { return next; }

    public ListNode<T> getPrev() { return prev; }

    public T getData() { return data; }

    public void setData(T data) { this.data = data; }

    @Override
    public String toString() { return "[" + data + "]"; }
}

/**
 * La clase LinkedList nos permite construir listas doblemente enlazadas.
 * 
 * @author David Bowman <dbowman2001 @ hal9000>
 * @version 1.0
 */
public class LinkedList<T> implements Iterable<T> {
    ListNode<T> head;   // referencia a la cabeza de la lista
    ListNode<T> tail;   // referencia a la cola de la lista
    int len;            // número de nodos de la lista

    /**
     * Devuelve el número de elementos en la lista.
     * 
     * @return número de elementos en la lista
     */
    public int size() {
        return len;
    }

    /**
     * Devuelve si la lista está vacía o no.
     * 
     * @return si la lista está vacía o no
     */
    public boolean isEmpty() {
        return (len == 0);
    }

    /**
     * Vacía la lista. Basta con poner la ocupación a 0.
     */
    public void clear() { this.len = 0; }    

    /**
     * Devuelve el elemento de la posición indicada de la lista.
     * 
     * @param index índice del elemento a devolver
     * @return el elemento en la posición indicada en la lista
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0 || index >= size())
     */    
    public T get(int index) {
        if (index >= len || index < 0) throw new IndexOutOfBoundsException();

        return getNode(index).getData();
    }

    private ListNode<T> getNode(int index) {
        if (index == 0) return head;
        if (index == len - 1) return tail;

        ListNode<T> node = head;
        while (index-->0) node = node.getNext();

        return node;
    }

    /**
     * Añade el nuevo elemento al final de la lista
     * 
     * @param obj nuevo elemento que se añadirá a la lista
     */
    public void add(final T data) {
        final ListNode<T> newNode = new ListNode<T>(data);

        if (len == 0)
            head = newNode;
        else
            tail.setNext(newNode);

        newNode.setPrev(tail);
        tail = newNode;

        len++;
    }

    /**
     * Inserta el nuevo elemento en la posición indicada.
     * 
     * @param index posición en la que se insertará el elemento
     * @param data   nuevo elemento que se añadirá a la lista
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0
     *                                   || index > size())
     */
    public void add(int index, final T data) {
        if (index > len || index < 0)
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        if (index == len)
            add(data);
        else {
            final ListNode<T> newNode = new ListNode<T>(data);
            final ListNode<T> oldNode = getNode(index);

            newNode.setNext(oldNode);
            if (index == 0)
                head = newNode;
            else {
                newNode.setPrev(oldNode.getPrev());
                oldNode.getPrev().setNext(newNode);
            }
            oldNode.setPrev(newNode);

            len++;
        }
    }

    /**
     * Actualiza el valor de la posición indicada con el nuevo valor suministrado.
     * 
     * @param index posición de la lista que se actualizará
     * @param obj   nuevo elemento en la posición indicada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0
     *                                   || index >= size())
     */
    public void set(int index, T obj) {
        if (index < 0 || index >= this.len)
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        getNode(index).setData(obj);
    }    

    /**
     * Elimina el valor en la posición indicada del array.
     * 
     * @param index posición del array que se borrará
     * @return el valor de la posición borrada
     * @throws IndexOutOfBoundsException si el índice está fuera de rango (index < 0
     *                                   || index >= size())
     */
    public T remove(final int index) {
        if (index >= len || index < 0)
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);

        ListNode<T> old, prev, next;

        old = getNode(index);
        prev = old.getPrev();
        next = old.getNext();

        if (index == len - 1)
            tail = prev;
        if (index == 0)
            head = next;

        if (prev != null)
            prev.setNext(next);
        if (next != null)
            next.setPrev(prev);

        len--;

        return old.getData();
    }

    /**
     * Elimina la primera ocurrencia del elemento si se encuentra en la lista.
     * 
     * @param obj elemento que se quiere eliminar
     * @return si se encontró (y borró) la cadena buscada o no
     */
    public boolean delete(T obj) {
        // Buscamos el elemento
        int index = this.indexOf(obj);

        // Eliminamos el elemento
        if (index != -1)
            this.remove(index);

        return (index != -1);
    }

    /**
     * Devuelve la posición de la primera ocurrencia del elemento en la lista.
     * 
     * @param obj objeto que se quiere buscar
     * @return posición en la lista del objeto buscado o -1 si no se encuentra
     */
    public int indexOf(T obj) {
        int index = 0;

        // Buscamos la primera ocurrencia del elemento
        ListNode<T> node = head;

        while(node!=null && !node.getData().equals(obj)) {
            index++;
            node = node.getNext();
        }
        return (index<this.len)?index:-1;
    }

    @Override
    public String toString() {
        if (this.len == 0) return "[]";

        ListNode<T> node = head;
        String ret = "";

        while (node != null) {
            ret += node.getData() + ", ";
            node = node.getNext();
        }
        return "[" + ret + "\b\b]";
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private ListNode<T> node = head;
            private int index = 0;

            @Override
            public boolean hasNext() { return index++<len; }
            
            @Override
            public T next() { 
                T data = node.getData();
                node = node.getNext();
                return data;
            }
        };
    }    
}
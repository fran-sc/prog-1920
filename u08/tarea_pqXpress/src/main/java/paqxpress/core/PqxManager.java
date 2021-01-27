package paqxpress.core;

import java.util.HashMap;
import java.util.ArrayList;

public class PqxManager {
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    HashMap<Integer, Paquete> paquetes = new HashMap<Integer, Paquete>();

    public boolean altaCliente(String id, String nombre) { 
        if(getCliente(id)!=null || id.length()==0 || nombre.length()==0) return false;        

        clientes.add(new Cliente(id, nombre));

        return true;
    }

    public Cliente[] listaClientes() {
        return clientes.toArray(new Cliente[clientes.size()]);
    }

    public Cliente getCliente(String id) {
        for(Cliente c: clientes) 
            if(c.getId().equals(id)) return c;

        return null;
    }

    public Paquete getPaquete(int id) { return paquetes.get(id); }

    public int altaEnvio(Cliente c, String destinatario, String destino) {
        Paquete pq = new Paquete(c, destinatario, destino);
        
        int id = pq.getId();
        paquetes.put(id, pq);

        return id;
    }

    public String consultarEstadoEnvio(int id) {
        Paquete pq = paquetes.get(id);

        return (pq!=null)?pq.getEstado().informaEstado():"Paquete no encontrado en el sistema";
    }

    public boolean cambiarEstadoEnvio(int id) {
        Paquete pq = paquetes.get(id);
        if(pq!=null && !(pq.getEstado() instanceof EstadoEntregado)) {
            pq.cambiaEstado();
            return true;
        }
        return false;
    }

    public Paquete[] listaPaquetesPorCliente(String id) {
        ArrayList<Paquete> lista = new ArrayList<Paquete>();
        for(Paquete pq: paquetes.values()) 
            if(pq.getCliente().getId().equals(id))
                lista.add(pq);
        return lista.toArray(new Paquete[lista.size()]);
    }   

    public Paquete[] listaPaquetesEnReparto() {
        ArrayList<Paquete> lista = new ArrayList<Paquete>();
        for(Paquete pq: paquetes.values()) 
            if(pq.getEstado() instanceof EstadoEnReparto)
                lista.add(pq);
        return lista.toArray(new Paquete[lista.size()]);
    }
}
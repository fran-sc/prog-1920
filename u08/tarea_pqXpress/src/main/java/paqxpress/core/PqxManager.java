package paqxpress.core;

import java.util.HashMap;
import java.util.ArrayList;

public class PqxManager {
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    HashMap<Integer, Paquete> paquetes = new HashMap<Integer, Paquete>();

    public void altaCliente(String id, String nombre) { 
        clientes.add(new Cliente(id, nombre));
    }

    public Cliente[] listaClientes() {
        return clientes.toArray(new Cliente[clientes.size()]);
    }
    
    public void altaEnvio(Cliente c, String destino) {
        Paquete pq = new Paquete(c, destino);
        paquetes.put(pq.getId(), pq);
    }

    public String consultarEstadoEnvio(int id) {
        return paquetes.get(id).getEstado().informaEstado();
    }

    public void cambiarEstadoEnvio(int id) {
        paquetes.get(id).cambiaEstado();
    }

    public Paquete[] listaPaquetesEnReparto() {
        ArrayList<Paquete> lista = new ArrayList<Paquete>();
        for(Paquete pq: paquetes.values()) 
            if(pq.getEstado() instanceof EstadoEnReparto)
                lista.add(pq);
        return lista.toArray(new Paquete[lista.size()]);
    }

    public Paquete[] listaPaquetesPorCliente(String id) {
        ArrayList<Paquete> lista = new ArrayList<Paquete>();
        for(Paquete pq: paquetes.values()) 
            if(pq.getCliente().getNombre().equals(id))
                lista.add(pq);
        return lista.toArray(new Paquete[lista.size()]);
    }    
}
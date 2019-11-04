//: facturacion/Factura.java
package facturacion;

class Factura {
    String numPieza;    // Identificador de la pieza
    String descripcion; // Descripción de la pieza
    int unidades;       // Número de unidades solicitadas
    double precio;      // Precio unitario de la pieza

    String getNumPieza() { return this.numPieza; }
    void setNumPieza(String numPieza) { this.numPieza = numPieza; }

    String getDescripcion() {  return this.descripcion; }
    void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    int getUnidades() { return this.unidades; }
    void setUnidades(int unidades) { this.unidades = unidades; }

    double getPrecio() { return this.precio; }
    void setPrecio(double precio) { this.precio = precio; }

    Factura(String numPieza, String descripcion, int unidades, double precio) {
        this.numPieza = numPieza;
        this.descripcion = descripcion;
        this.unidades = unidades;
        this.precio = precio;
    }

    double obtenerMontoFactura() { return unidades*precio; }
}

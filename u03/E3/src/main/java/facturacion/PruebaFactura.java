//: facturacion/PruebaFactura.java
package facturacion;

class PruebaFactura {
    static void imprimeLineaDetalle(Factura f) {
        System.out.printf("%-6s %-25s %8d %9.2f€ %9.2f€ %n", 
            f.getNumPieza(), f.getDescripcion(), f.getUnidades(),
            f.getPrecio(), f.obtenerMontoFactura());
    }

    public static void main(String[] args) {
        Factura f1 = new Factura("M00143", "Tornillo M3x10mm", 50, 0.05);
        Factura f2 = new Factura("M00242", "Arandela M3 inox", 100, 0.02);
        Factura f3 = new Factura("M00235", "Tuerca M3", 100, 0.04);

        System.out.println("\tI M P O R T E S");
        System.out.println("\t---------------");
        System.out.printf("%-6s %-25s %8s %10s %10s %n", 
                            "REF", "DESCRIPCION", "UNIDADES", "PRECIO", "IMPORTE");
        
        imprimeLineaDetalle(f1);
        imprimeLineaDetalle(f2);
        imprimeLineaDetalle(f3);
    }
}
/* Output:
        I M P O R T E S
        ---------------
REF    DESCRIPCION               UNIDADES     PRECIO    IMPORTE 
M00143 Tornillo M3x10mm                50      0,05€      2,50€ 
M00242 Arandela M3 inox               100      0,02€      2,00€ 
M00235 Tuerca M3                      100      0,04€      4,00€ 
*///:~



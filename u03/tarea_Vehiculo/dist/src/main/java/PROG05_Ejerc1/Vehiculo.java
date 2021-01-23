package PROG05_Ejerc1;

import java.time.LocalDate;

/**
 * Representa un vehículo.
 *
 * @author
 * @version 1.0
 */
public class Vehiculo {
    private String marca;
    private String matricula;
    private int numKM;
    private LocalDate fechMatricula;
    private String descripcion;
    private double precio;
    private String nomPropietario;
    private String dniPropietario;

    /**
     * Constructor
     *
     * @param marca marca o fabricante del vehículo.
     * @param matricula matrícula del vehículo.
     * @param numKM kilometraje actual del vehuclo.
     * @param fechaMatricula fecha de matriculación del vehículo.
     * @param descricpción modelo, motorización y descripción del vehículo.
     * @param precio precio venta del vehículo.
     * @param nomPropietario nombre del propietario.
     * @param dniPropietario DNI del propietario.
     */
    Vehiculo(String marca, String matricula, int numKM, LocalDate fechMatricula, String descripcion,
        double precio, String nomPropietario, String dniPropietario) {
        this.marca = marca;
        this.matricula = matricula;
        this.numKM = numKM;
        this.fechMatricula = fechMatricula;
        this.descripcion = descripcion;
        this.precio = precio;
        this.nomPropietario = nomPropietario;
        this.dniPropietario = dniPropietario;
    }

    /** Devuelve la marca del vehículo. */
    public String getMarca() {
        return this.marca;
    }

    /** Devuelve la matrícula. */
    public String getMatricula() {
        return this.matricula;
    }

    /** Devuelve el kilometraje actual. */
    public int getNumKM() {
        return this.numKM;
    }

    /**
     * Actualiza el kilometraje actual.
     * @param numKM nuevo valor del kilometraje.
     * */
    public void setNumKM(int numKM) {
        this.numKM = numKM;
    }

    /** Devuelve la fecha de matriculación. */
    public LocalDate getFechMatricula() {
        return this.fechMatricula;
    }

    /** Devuelve la descripción. */
    public String getDescripcion() {
        return this.descripcion;
    }

    /** Devuelve el precio. */
    public double getPrecio() {
        return this.precio;
    }

    /** Devuelve el nombre del propietario. */
    public String getNomPropietario() {
        return this.nomPropietario;
    }

    /** Devuelve el DNI del propietario. */
    public String getDNIPropietario() {
        return this.dniPropietario;
    }

    /**
     * Devuelve la edad del vehículo en años.
     *
     * @return años completos transcurridos desde la matriculación hasta la fecha actual.
     * */
    public int getAnios(Vehiculo v) {
        LocalDate fechActual = LocalDate.now();

        return (int) (((fechActual.getYear() * 12 + fechActual.getMonthValue())
                          - (fechMatricula.getYear() * 12 + fechMatricula.getMonthValue()))/ 12);
    }
}

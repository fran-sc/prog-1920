package vehiculo.util;

import java.time.LocalDate;

public class Util {
    /** Valida el kilometraje. */
    public static boolean validaKM(int km) {
        return (km > 0);
    }

    /** Valida que la fecha de matriculación sea anterior a la fecha actual. */
    public static boolean validaFechaMat(LocalDate fechMatricula) {
        return (LocalDate.now().compareTo(fechMatricula) >= 0) ? true : false;
    }

    /**
     * Valida la letra del DNI sólo para epañoles mayores de 18 años.
     * 
     * @param dni DNI del propietario del vehículo
     * @throws Exception
     */
    public static void validaDNI(String dni) throws Exception {
        String letras="TRWAGMYFPDXBNJZSQVHLCKE";
        String dniEspecial = "LMXYZ";

        if(dni.length()!=9)
            throw new Exception("Longitud de DNI incorrecta");

        dni = dni.toUpperCase();

        // Chequea si es un DNI especial (extranjeros,...). No se hace la validación del dígito de control
        if(dniEspecial.indexOf(dni.charAt(0))>=0)
            return;

        try {
            int dni_num = Integer.parseInt(dni.substring(0, 8));
            if(letras.charAt(dni_num%23) != dni.charAt(8))
                throw new Exception("Letra de DNI incorrecta");
        }        
        catch (NumberFormatException e) {
            throw new Exception("Número DNI no válido");
        }
    }
}

package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private List<Operacion> operaciones = new ArrayList<Operacion>();
    private Establecimiento establecimiento;
    private String nombre;

    public Sucursal(final String nombre) {
        this.nombre = nombre;
    }

    public List<Operacion> obtenerOperaciones() {
        return this.operaciones;
    }

    public void comprar(final Cliente cliente,
                        final List<Producto> productos,
                        final Mes mes) throws BeneficioException {

        Beneficio beneficio =
                    this.establecimiento.tieneBeneficio(
                            cliente.obtenerTarjeta());

        /*if (beneficio != null) {*/

            Operacion nuevaOperacion = new Operacion(beneficio,
                                                     productos,
                                                        mes, this);
            this.operaciones.add(nuevaOperacion);
            cliente.registrarOperacion(nuevaOperacion);
        /*} else {
            throw new BeneficioException("El establecimiento no "
                    + "cuenta con beneficio para la tarjeta solicitada");
        }*/
    }

    public void asignarEstablecimiento(final Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Establecimiento obtenerEstablecimiento() {
        return this.establecimiento;
    }

}

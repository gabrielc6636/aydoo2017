package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Sucursal {

    private List<Operacion> operaciones = new ArrayList<Operacion>();
    private Establecimiento establecimiento;

    public List<Operacion> getOperaciones() {
        return this.operaciones;
    }

    public void comprar(Cliente cliente, int importeOriginal) throws BeneficioException {

        Beneficio beneficio = this.establecimiento.tieneBeneficio(cliente.obtenerTarjeta());

        if (beneficio!=null) {

            Operacion nuevaOperacion = new Operacion(beneficio, importeOriginal);
            
            this.operaciones.add(nuevaOperacion);
            cliente.registrarOperacion(nuevaOperacion);
        
        } else {
            throw new BeneficioException();
        }
    }

    public void asignarEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

}
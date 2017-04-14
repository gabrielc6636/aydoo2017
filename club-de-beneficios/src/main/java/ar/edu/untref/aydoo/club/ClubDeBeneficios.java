package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private List<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {

        this.establecimientos.add(establecimiento);
    }

    public Establecimiento obtenerEstablecimientoAFelicitar() {

        Establecimiento establecimientoGanador = new Establecimiento();
        int cantidadDeOperaciones = 0;

        for(Establecimiento establecimiento: establecimientos){
            List<Sucursal> sucursales = establecimiento.obtenerSucursales();
            int operaciones = 0;

            for(Sucursal sucursal:sucursales){
                operaciones = operaciones+sucursal.getOperaciones().size();
            }

            if(operaciones>cantidadDeOperaciones){
                cantidadDeOperaciones = operaciones;
                establecimientoGanador = establecimiento;
            }
        }

        return establecimientoGanador;
    }

    public Sucursal obtenerSucursalAFelicitar(){
        return establecimientos.get(0).obtenerSucursales().get(0);
    }

}
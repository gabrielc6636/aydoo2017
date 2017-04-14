package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class ClubDeBeneficios {

    private List<Establecimiento> establecimientos = new ArrayList<Establecimiento>();
    
    public void agregarEstablecimiento(Establecimiento establecimiento) {

        this.establecimientos.add(establecimiento);
    }

    public Establecimiento obtenerEstablecimientoAFelicitar() {

        return this.establecimientos.get(0);
    }

}
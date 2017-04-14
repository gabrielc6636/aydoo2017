package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private List<Sucursal> sucursales = new ArrayList<Sucursal>();
    private List<Beneficio> beneficios = new ArrayList<Beneficio>();

    public void agregarSucursal(Sucursal sucursal) {
        
        this.sucursales.add(sucursal);
        sucursal.asignarEstablecimiento(this);
    }

    public void agregarBeneficio(Beneficio beneficio) {
        this.beneficios.add(beneficio);
    }

    public boolean tieneBeneficio(Tarjeta tarjeta) {
        
        boolean tiene = false;
        
        for(int i = 0 ; i < this.beneficios.size() && !tiene ; i++) {
            
            Beneficio beneficio = this.beneficios.get(i);
            tiene = beneficio.obtenerTarjeta().equals(tarjeta);
        }
        
        return tiene;
    }

}
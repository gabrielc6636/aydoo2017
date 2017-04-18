package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

public class Establecimiento {

    private List<Sucursal> sucursales = new ArrayList<Sucursal>();
    private List<Beneficio> beneficios = new ArrayList<Beneficio>();
    private String nombre = new String();

    public Establecimiento(final String nombre) {
        this.nombre = nombre;
    }

    public void agregarSucursal(final Sucursal sucursal) {
        
        this.sucursales.add(sucursal);
        sucursal.asignarEstablecimiento(this);
    }

    public List<Sucursal> obtenerSucursales() {
        return this.sucursales;
    }

    public void agregarBeneficio(final Beneficio beneficio) {
        this.beneficios.add(beneficio);
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    public Beneficio tieneBeneficio(final Tarjeta tarjeta) {
        
        boolean tiene = false;
        Beneficio beneficio = null;

        for (int i = 0; i < this.beneficios.size() && !tiene; i++) {
            
            beneficio = this.beneficios.get(i);
            tiene = beneficio.obtenerTarjeta().equals(tarjeta);
        }

        if (!tiene) {
            beneficio = null;
        }

        return beneficio;
    }

}

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

    public Beneficio tieneBeneficio(Tarjeta tarjeta) throws BeneficioException {
        
        boolean tiene = false;
        Beneficio beneficio = this.beneficios.get(0);

        for(int i = 0 ; i < this.beneficios.size() && !tiene ; i++) {
            
            beneficio= this.beneficios.get(i);
            tiene = beneficio.obtenerTarjeta().equals(tarjeta);
        }

        if(!tiene){
            throw new BeneficioException();
        }

        return beneficio;
    }

}
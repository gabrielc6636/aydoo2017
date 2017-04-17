package ar.edu.untref.aydoo.club;

import java.util.List;

public class Beneficio {

    protected Tarjeta tarjeta;
    protected int valor;

    public Beneficio(Tarjeta tarjeta, int valor) throws BeneficioException {
        this.tarjeta = tarjeta;
        if(valor>5) {
            this.valor = valor;
        }
        else{
            throw new BeneficioException("El porcentaje del descuento es menor a 5%");
        }
    }
    
    public Tarjeta obtenerTarjeta(){
        return this.tarjeta;
    }

    public double obtenerValorBeneficio(List<Producto> productos)  throws BeneficioException {

        double importeOriginal = 0;

        for(Producto producto: productos){
            importeOriginal = importeOriginal+producto.obtenerImporte();
        }

        return importeOriginal-(((100-this.valor)*importeOriginal) / 100.0);
    }

}

package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
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

    public List<Producto> obtenerValorBeneficio(List<Producto> productos)  throws BeneficioException {

        List<Producto> productosConBeneficio = new ArrayList<Producto>();

        for(Producto producto: productos){

            double importeOriginal = 0;

            importeOriginal = importeOriginal+producto.obtenerImporte();

            producto.asignarBeneficio(importeOriginal-(((100-this.valor)*importeOriginal) / 100.0));

            productosConBeneficio.add(producto);
        }

        return productosConBeneficio;
    }

}

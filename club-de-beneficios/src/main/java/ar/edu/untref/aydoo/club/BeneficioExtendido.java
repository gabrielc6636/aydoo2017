package ar.edu.untref.aydoo.club;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by gabriel on 16/04/17.
 */
public class BeneficioExtendido extends Beneficio {

    private Tarjeta tarjeta;
    private int valor;

    public BeneficioExtendido(Tarjeta tarjeta, int valor) throws BeneficioException {
        super(tarjeta,valor);
        this.tarjeta = tarjeta;
        this.valor = valor;

    }

    public double obtenerValorBeneficio(List<Producto> productos) throws BeneficioException {

        Collections.sort(productos,Collections.reverseOrder() );

        int cantProductos = productos.size();

        if(cantProductos<2){
            throw new BeneficioException("El beneficio de 2x1 no se puede aplicar a solo un producto");
        }

        double importeOriginal = productos.get(cantProductos-1).obtenerImporte();

        return importeOriginal-(((100-this.valor)*importeOriginal) / 100.0);
    }
}

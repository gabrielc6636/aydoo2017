package ar.edu.untref.aydoo.club;

import java.util.List;

/**
 * Created by gabriel on 16/04/17.
 */
public class BeneficioExtendido extends Beneficio {

    private Tarjeta tarjeta;
    private int valor;

    public BeneficioExtendido(Tarjeta tarjeta, int valor) throws BeneficioException {
        super(tarjeta,valor);
    }

    public double obtenerValorBeneficio(List<Producto> productos) {

        double importeOriginal = 0;

        for(Producto producto: productos){
            importeOriginal = importeOriginal+producto.obtenerImporte();
        }

        return importeOriginal-(((100-this.valor)*importeOriginal) / 100.0);
    }
}

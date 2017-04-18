package ar.edu.untref.aydoo.club;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by gabriel on 16/04/17.
 */
public class BeneficioExtendido extends Beneficio {

    private Tarjeta tarjeta;
    private int valor;

    public BeneficioExtendido(final Tarjeta tarjeta, final int valor) throws BeneficioException {
        super(tarjeta, valor);
        this.tarjeta = tarjeta;
        this.valor = valor;

    }

    public List<Producto> obtenerValorBeneficio(final List<Producto> productos) throws BeneficioException {

        Collections.sort(productos, Collections.reverseOrder());

        List<Producto> productosConBeneficio = new ArrayList<Producto>();

        int cantProductos = productos.size();

        if (cantProductos < 2) {
            throw new BeneficioException("El beneficio de 2x1 no se puede aplicar a solo un producto");
        }

        double importeOriginal = productos.get(cantProductos - 1).obtenerImporte();

        productos.get(cantProductos - 1).asignarBeneficio(importeOriginal - (((100 - this.valor) * importeOriginal) / 100.0));

        for (Producto producto: productos) {
            productosConBeneficio.add(producto);
        }

        return productosConBeneficio;


    }
}

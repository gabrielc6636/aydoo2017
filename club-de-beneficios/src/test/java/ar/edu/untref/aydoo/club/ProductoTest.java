package ar.edu.untref.aydoo.club;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gabriel on 16/04/17.
 */
public class ProductoTest {

    @Test
    public void siCargoUnProductoDeberiaObtenerlo(){

        Producto producto = new Producto(20.0,"ProductoTest");

        Assert.assertEquals(20.0,producto.obtenerImporte(), 0.005);

    }
}

package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gabriel on 20/03/17.
 */
public class FactoresPrimosTest {
    @Test
    public void factoresTest1() throws Exception {

        int valor = 360;

        FactoresPrimos factoresPrimos = new FactoresPrimos(valor);
        factoresPrimos.factores(valor);
        Assert.assertTrue(true);
    }
    @Test
    public void factoresTest2() throws Exception {

        int valor = 90;

        FactoresPrimos factoresPrimos = new FactoresPrimos(valor);
        factoresPrimos.factores(valor);
        Assert.assertTrue(true);
    }
}
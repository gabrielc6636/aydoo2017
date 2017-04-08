package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;



/**
 * Created by gabriel on 20/03/17.
 */
public class FactoresPrimosTest {
    @Test
    public void TestFactorPrimo360()
    {
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        List<Integer> lstFactores = factoresPrimos.CalcularFactores(360);

        for (Integer factor : lstFactores) {
            System.out.print(factor+" ");
        }

        Assert.assertEquals(6, lstFactores.size());
    }

    @Test
    public void TestFactorPrimo90()
    {
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        List<Integer> lstFactores = factoresPrimos.CalcularFactores(90);

        for (Integer factor : lstFactores) {
            System.out.print(factor+" ");
        }

        Assert.assertEquals(4, lstFactores.size());
    }
}
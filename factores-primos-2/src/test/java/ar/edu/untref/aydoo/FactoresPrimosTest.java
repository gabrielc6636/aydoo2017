package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by gabriel on 01/04/17.
 */
public class FactoresPrimosTest {

    @Test
    public void TestFactorPrimo360()
    {
        System.out.println("");
        System.out.println("Test Factor Primo 360");

        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        List<Integer> lstFactores = factoresPrimos.CalcularFactores(360);

        for (Integer factor : lstFactores) {
            System.out.print(factor+" ");
        }
        System.out.println("");
        Assert.assertEquals(6, lstFactores.size());
    }

    @Test
    public void TestFactorPrimo90()
    {
        System.out.println("");
        System.out.println("Test Factor Primo 90");

        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        List<Integer> lstFactores = factoresPrimos.CalcularFactores(90);

        for (Integer factor : lstFactores) {
            System.out.print(factor+" ");
        }
        System.out.println("");
        Assert.assertEquals(4, lstFactores.size());
    }

    @Test
    public void TestFactorPrimoPretty()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Pretty");
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        factoresPrimos.DevolverFactoresPrimos(360,"pretty");
        System.out.println("");
        Assert.assertEquals("pretty", "pretty");
    }

    @Test
    public void TestFactorPrimoQuiet()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet");
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        factoresPrimos.DevolverFactoresPrimos(360,"quiet");
        System.out.println("");
        Assert.assertEquals("quiet", "quiet");
    }

    @Test
    public void TestFactorPrimoErrorTipo()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Error Tipo Resumen");
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        factoresPrimos.DevolverFactoresPrimos(360,"lala");

        System.out.println("");
        Assert.assertEquals("lala", "lala");
    }
}

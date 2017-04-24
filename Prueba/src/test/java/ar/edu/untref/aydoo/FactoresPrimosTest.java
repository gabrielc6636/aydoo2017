package ar.edu.untref.aydoo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
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

        List<Integer> lstFactoresEsperados = new ArrayList<Integer>();
        lstFactoresEsperados.add(2);
        lstFactoresEsperados.add(2);
        lstFactoresEsperados.add(2);
        lstFactoresEsperados.add(3);
        lstFactoresEsperados.add(3);
        lstFactoresEsperados.add(5);
        List<Integer> lstFactores = new ArrayList<Integer>();

        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();

        lstFactores = factorizador.calcularFactores(360);

        for (Integer factor : lstFactores) {
            System.out.print(factor+" ");
        }
        System.out.println("");

        Assert.assertTrue(lstFactoresEsperados.equals(lstFactores));
    }

    @Test
    public void TestFactorPrimo90()
    {
        System.out.println("");
        System.out.println("Test Factor Primo 90");

        List<Integer> lstFactoresEsperados = new ArrayList<Integer>();
        lstFactoresEsperados.add(2);
        lstFactoresEsperados.add(3);
        lstFactoresEsperados.add(3);
        lstFactoresEsperados.add(5);
        List<Integer> lstFactores = new ArrayList<Integer>();

        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();

        lstFactores = factorizador.calcularFactores(90);

        for (Integer factor : lstFactores) {
            System.out.print(factor+" ");
        }
        System.out.println("");

        Assert.assertTrue(lstFactoresEsperados.equals(lstFactores));
    }

    @Test
    public void TestFactorPrimoPrettyPara360Integral()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Pretty para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;

        FactoresPrimos factoresPrimos = new FactoresPrimos();

        String strImpresionObtenida = factoresPrimos.devolverFactoresPrimos(intNumeroAFactorizar,"pretty","--sort:asc");
        String strImpresionDeseada = "Factores primos " + Integer.toString(intNumeroAFactorizar) + ": 2 2 2 3 3 5 ";


        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoPrettyPara360()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Pretty para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "Factores primos " + Integer.toString(intNumeroAFactorizar) + ": 2 2 2 3 3 5 ";
        String strImpresionObtenida = impresor.imprimirEnFormatoPretty(intNumeroAFactorizar, lstFactores,"");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoPrettyPara90()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Pretty para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "Factores primos " + Integer.toString(intNumeroAFactorizar) + ": 2 3 3 5 ";
        String strImpresionObtenida = impresor.imprimirEnFormatoPretty(intNumeroAFactorizar, lstFactores,"");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoQuietPara360()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "5\n3\n3\n2\n2\n2\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoQuietPara360SortDes()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "2\n2\n2\n3\n3\n5\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:des");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoQuietPara360SortAsc()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);


        String strImpresionDeseada = "5\n3\n3\n2\n2\n2\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:asc");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoQuietPara90()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "5\n3\n3\n2\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoQuietPara90SortDes()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "2\n3\n3\n5\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:des");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoQuietPara90SortAsc()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "5\n3\n3\n2\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:asc");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void TestFactorPrimoErrorTipo()
    {
        System.out.println("");
        System.out.println("Test Factor Primo Error Tipo Resumen");
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        String strImpresionObtenida = factoresPrimos.devolverFactoresPrimos(360,"TipoResumenCualquiera","");

        System.out.println(strImpresionObtenida);

        Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", strImpresionObtenida);
    }

    @Test
    public void TestIntegral() throws IOException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;

        String[] args = new String[3];
        args[0] = "360";
        args[1] = "--format=quiet";
        args[2] = "--sort:asc";
        args[3] = "--output-file=salida.txt";

        FactoresPrimos.main(args);

        String strImpresionDeseada = "5\n3\n3\n2\n";

        int posicion = 14;
        String rutaImpresion = "salida.txt";
        String ruta = rutaImpresion.substring(posicion);
        FactoresPrimosIO factoresPrimosIO = new FactoresPrimosIO(ruta);

        String strImpresionObtenida = factoresPrimosIO.leerFactorizacion();

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }
}

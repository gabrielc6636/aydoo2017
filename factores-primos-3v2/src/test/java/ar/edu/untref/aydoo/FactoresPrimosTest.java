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
    public void testFactorPrimo360() throws FactorizadorException
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

    @Test (expected = FactorizadorException.class)
    public void testFactorPrimo1ObtengoException() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo 1");

        List<Integer> lstFactores = new ArrayList<Integer>();

        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();

        lstFactores = factorizador.calcularFactores(1);
    }

    @Test
    public void testFactorPrimo90() throws FactorizadorException
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
    public void testFactorPrimoPrettyPara360Integral() throws FactorizadorException
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
    public void testFactorPrimodDefaultPrettyPara360Integral() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Pretty para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;

        FactoresPrimos factoresPrimos = new FactoresPrimos();

        String strImpresionObtenida = factoresPrimos.devolverFactoresPrimos(intNumeroAFactorizar,"","--sort:asc");
        String strImpresionDeseada = "Factores primos " + Integer.toString(intNumeroAFactorizar) + ": 2 2 2 3 3 5 ";


        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoPrettyPara360() throws FactorizadorException
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
    public void testFactorPrimoPrettyPara90() throws FactorizadorException
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
    public void testFactorPrimoQuietPara360() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "2\n2\n2\n3\n3\n5\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoQuietPara360SortDes() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "5\n3\n3\n2\n2\n2\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:des");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoQuietPara360SortAsc() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 360");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 360;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "2\n2\n2\n3\n3\n5\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:asc");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoQuietPara90() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "2\n3\n3\n5\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoQuietPara90SortDes() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "5\n3\n3\n2\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:des");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoQuietPara90SortAsc() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;
        int intNumeroAFactorizar = 90;
        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

        String strImpresionDeseada = "2\n3\n3\n5\n";
        String strImpresionObtenida = impresor.imprimirEnFormatoQuiet(lstFactores,"--sort:asc");

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        System.out.println(strImpresionObtenida);

        Assert.assertTrue(blnFactorizacion);
    }

    @Test
    public void testFactorPrimoErrorTipo() throws FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Error Tipo Resumen");
        FactoresPrimos factoresPrimos  = new FactoresPrimos();

        String strImpresionObtenida = factoresPrimos.devolverFactoresPrimos(360,"TipoResumenCualquiera","");

        System.out.println(strImpresionObtenida);

        Assert.assertEquals("Formato no aceptado. Las opciones posibles son: pretty o quiet.", strImpresionObtenida);
    }

    @Test
    public void testIntegral() throws IOException,FactorizadorException
    {
        System.out.println("");
        System.out.println("Test Factor Primo Quiet para 90");

        boolean blnFactorizacion;

        String[] args = new String[4];
        args[0] = "90";
        args[1] = "--format=quiet";
        args[2] = "--sort:des";
        args[3] = "--output-file=salida.txt";

        FactoresPrimos.main(args);

        String strImpresionDeseada = "5\n3\n3\n2\n";

        String ruta = "salida.txt";
        FactoresPrimosIO factoresPrimosIO = new FactoresPrimosIO(ruta);

        String strImpresionObtenida = factoresPrimosIO.leerFactorizacion();

        blnFactorizacion = strImpresionObtenida.equals(strImpresionDeseada);

        args[3] = "";
        FactoresPrimos.main(args);

        Assert.assertTrue(blnFactorizacion);
    }
}

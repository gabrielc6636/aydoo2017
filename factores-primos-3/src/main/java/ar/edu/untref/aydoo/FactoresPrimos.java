package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.*;

/**
 * Created by gabriel on 01/04/17.
 */
public class FactoresPrimos {
    private static int numeroAFactorizar;
    private static String formatoDeImpresion;
    private static String formatoDeOrden;
    private static String nombreDeArchivo;

    public String devolverFactoresPrimos(int intNumeroAFactorizar, String strFormato){

        String strRetorno = "";

        if(strFormato.equals("quiet")||strFormato.equals("pretty")) {

            FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
            FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

            List<Integer> lstFactores = factorizador.calcularFactores(intNumeroAFactorizar);

            switch (strFormato) {
                case "pretty":
                    strRetorno = impresor.imprimirEnFormatoPretty(intNumeroAFactorizar,lstFactores);
                    break;
                case "quiet":
                    strRetorno = impresor.imprimirEnFormatoQuiet(lstFactores);
                    break;
                default:
                    break;
            }
        }
        else
        {
            strRetorno = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
        }

        return strRetorno;
    }

    private static void obtenerParametros(String[] args) {

        FactoresPrimosParametros parametros = new FactoresPrimosParametros(args);
        numeroAFactorizar = parametros.obtenerNumeroAFactorizar();
        formatoDeImpresion = parametros.obtenerFormatoDeSalida();
        formatoDeOrden = parametros.obtenerFormatoDeOrden();
        nombreDeArchivo = parametros.obtenerNombreDeArchivo();

    }

    public static void main(String[]args)throws IOException {

        obtenerParametros(args);

        System.out.println("Formato: "+formatoDeImpresion);

        System.out.println("El número es: "+numeroAFactorizar);

        FactoresPrimos factoresPrimos=new FactoresPrimos();

        System.out.println("Los factores primos son:");

        String strImpresion = factoresPrimos.devolverFactoresPrimos(numeroAFactorizar,formatoDeImpresion);

        System.out.println(strImpresion);

    }
}

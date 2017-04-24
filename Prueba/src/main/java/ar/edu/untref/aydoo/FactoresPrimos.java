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

    public String devolverFactoresPrimos(int numeroAFactorizar, String formatoDeImpresion, String formatoDeOrden){

        String strRetorno = "";

        FactoresPrimosFactorizador factorizador = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor = new FactoresPrimosImpresor();

        List<Integer> lstFactores = factorizador.calcularFactores(numeroAFactorizar);

        formatoDeImpresion = formatoDeImpresion.replaceAll("--format=","").toLowerCase();

        switch (formatoDeImpresion) {
            case "":
                strRetorno = impresor.imprimirEnFormatoPretty(numeroAFactorizar,lstFactores,formatoDeOrden);
                break;
            case "pretty":
                strRetorno = impresor.imprimirEnFormatoPretty(numeroAFactorizar,lstFactores,formatoDeOrden);
                break;
            case "quiet":
                strRetorno = impresor.imprimirEnFormatoQuiet(lstFactores,formatoDeOrden);
                break;
            default:
                strRetorno = "Formato no aceptado. Las opciones posibles son: pretty o quiet.";
                break;
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

    private static void imprimirArchivo(String pathImpresion, String impresion) throws IOException {

        String ruta = pathImpresion.replaceAll("--output-file=","");
        FactoresPrimosIO factoresPrimosIO = new FactoresPrimosIO(ruta);
        factoresPrimosIO.escribirFactorizacion(impresion);

    }

    public static void main(String[]args)throws IOException {

        obtenerParametros(args);

        System.out.println("Formato: "+formatoDeImpresion);

        System.out.println("El número es: "+numeroAFactorizar);

        FactoresPrimos factoresPrimos=new FactoresPrimos();

        System.out.println("Los factores primos son:");

        String impresion = factoresPrimos.devolverFactoresPrimos(numeroAFactorizar,formatoDeImpresion,formatoDeOrden);

        if (nombreDeArchivo == ""){
            System.out.println(impresion);
        }else{
            imprimirArchivo(nombreDeArchivo, impresion);
        }

    }


}

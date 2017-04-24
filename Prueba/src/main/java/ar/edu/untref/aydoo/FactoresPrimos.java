package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.List;

/**
 * Created by gabriel on 01/04/17.
 */
public class FactoresPrimos {
    private static int numeroAFactorizar;
    private static String formatoDeImpresion;
    private static String formatoDeOrden;
    private static String nombreDeArchivo;

    public String devolverFactoresPrimos(
            final int numeroPorFactorizar,
            final String formatoParaImpresion,
            final String formatoParaOrden) throws FactorizadorException {
        String strRetorno = "";

        String formatoParaLaImpresion = formatoParaImpresion;

        FactoresPrimosFactorizador factorizador
                = new FactoresPrimosFactorizador();
        FactoresPrimosImpresor impresor
                = new FactoresPrimosImpresor();

        List<Integer> lstFactores
                = factorizador.calcularFactores(
                        numeroPorFactorizar);

        formatoParaLaImpresion = formatoParaLaImpresion
                .replaceAll("--format=", "")
                .toLowerCase();

        switch (formatoParaLaImpresion) {
            case "":
                strRetorno = impresor.imprimirEnFormatoPretty(
                        numeroPorFactorizar,
                        lstFactores,
                        formatoParaOrden);
                break;
            case "pretty":
                strRetorno = impresor.imprimirEnFormatoPretty(
                        numeroPorFactorizar,
                        lstFactores,
                        formatoParaOrden);
                break;
            case "quiet":
                strRetorno = impresor.imprimirEnFormatoQuiet(
                        lstFactores,
                        formatoParaOrden);
                break;
            default:
                strRetorno = "Formato no aceptado. "
                        + "Las opciones posibles son: pretty o quiet.";
                break;
        }
        return strRetorno;
    }

    private static void obtenerParametros(
            final String[] args) {
        FactoresPrimosParametros parametros
                = new FactoresPrimosParametros(args);
        numeroAFactorizar = parametros.obtenerNumeroAFactorizar();
        formatoDeImpresion = parametros.obtenerFormatoDeSalida();
        formatoDeOrden = parametros.obtenerFormatoDeOrden();
        nombreDeArchivo = parametros.obtenerNombreDeArchivo();
    }

    private static void imprimirArchivo(
            final String rutaDeImpresion,
            final String impresion)
            throws IOException {
        String ruta = rutaDeImpresion.replaceAll("--output-file=", "");
        FactoresPrimosIO factoresPrimosIO = new FactoresPrimosIO(ruta);
        factoresPrimosIO.escribirFactorizacion(impresion);
    }

    public static void main(final String[]args)
            throws IOException, FactorizadorException {
        obtenerParametros(args);
        FactoresPrimos factoresPrimos = new FactoresPrimos();
        String impresion = factoresPrimos
                .devolverFactoresPrimos(
                        numeroAFactorizar,
                        formatoDeImpresion,
                        formatoDeOrden);

        if (nombreDeArchivo.isEmpty()) {
            System.out.println(impresion);
        } else {
            imprimirArchivo(nombreDeArchivo, impresion);
        }
    }
}

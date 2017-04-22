package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.*;

/**
 * Created by gabriel on 01/04/17.
 */
public class FactoresPrimos {
    int intNumeroAFactorizar;

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




    public static void main(String[]args)throws IOException {

        String strFormatoSalida = "";

        int intNumeroAFactorizar = Integer.parseInt(args[0]);

        if(args.length>1) {
            strFormatoSalida = args[1].replaceAll("--format=", "").trim().toLowerCase();
        }

        System.out.println("Formato: "+strFormatoSalida);

        System.out.println("El número es: "+intNumeroAFactorizar);

        FactoresPrimos factoresPrimos=new FactoresPrimos();

        System.out.println("Los factores primos son:");

        String strImpresion = factoresPrimos.devolverFactoresPrimos(intNumeroAFactorizar,strFormatoSalida);

        System.out.println(strImpresion);

    }
}

package ar.edu.untref.aydoo;

import java.io.IOException;
import java.util.*;

/**
 * Created by gabriel on 01/04/17.
 */
public class FactoresPrimos {
    int intNumeroAFactorizar;

    public List<Integer> calcularFactores(int intNumeroAFactorizar){


        this.intNumeroAFactorizar = intNumeroAFactorizar;
        int intFactor = 2;
        List<Integer> lstFactores = new LinkedList<Integer>();

        if(Integer.class.isInstance(this.intNumeroAFactorizar)) {
            if(this.intNumeroAFactorizar>1) {
                while(this.intNumeroAFactorizar!=1)
                {
                    while(this.intNumeroAFactorizar%intFactor==0)
                    {
                        this.intNumeroAFactorizar /= intFactor;
                        lstFactores.add(intFactor);
                    }
                    intFactor++;
                }
            }
            else {
                System.out.println("El valor debe ser mayor a 1");
            }
        }

        return lstFactores;
    }

    public String devolverFactoresPrimos(int intNumeroAFactorizar, String strFormato){

        String strRetorno = "";

        if(strFormato.equals("quiet")||strFormato.equals("pretty")) {

            List<Integer> lstFactores = calcularFactores(intNumeroAFactorizar);

            switch (strFormato) {
                case "pretty":
                    strRetorno = imprimirEnFormatoPretty(intNumeroAFactorizar,lstFactores);
                    break;
                case "quiet":
                    strRetorno = imprimirEnFormatoQuiet(lstFactores);
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

    public String imprimirEnFormatoPretty(int numeroAFactorizar, List<Integer> lstFactores){

        String strFactoresPretty = "Factores primos "  + Integer.toString(numeroAFactorizar) + ": ";

        Iterator<Integer> itListaFactores = lstFactores.iterator();
        while(itListaFactores.hasNext()){
            strFactoresPretty = strFactoresPretty + Integer.toString(itListaFactores.next()) + ' ';
        }

        return strFactoresPretty;
    }

    public String imprimirEnFormatoQuiet(List<Integer> lstFactores) {

        String strFactoresQuiet = "";

        ListIterator<Integer> itListaFactores = lstFactores.listIterator(lstFactores.size());

        while (itListaFactores.hasPrevious()){
            strFactoresQuiet = strFactoresQuiet + Integer.toString(itListaFactores.previous()) + "\n";
        }

        return strFactoresQuiet;
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

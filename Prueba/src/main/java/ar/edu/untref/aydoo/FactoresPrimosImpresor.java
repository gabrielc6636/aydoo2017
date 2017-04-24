package ar.edu.untref.aydoo;

import java.util.*;

/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosImpresor {

    public String imprimirEnFormatoPretty(int numeroAFactorizar, List<Integer> lstFactores,String formatoDeOrden){

        String strFactoresPretty = "Factores primos "  + Integer.toString(numeroAFactorizar) + ": ";

        List<Integer> listaDeFactores = ordenarLista(lstFactores,formatoDeOrden);

        Iterator<Integer> itListaFactores = listaDeFactores.iterator();
        while(itListaFactores.hasNext()){
            strFactoresPretty = strFactoresPretty + Integer.toString(itListaFactores.next()) + ' ';
        }

        return strFactoresPretty;
    }

    public String imprimirEnFormatoQuiet(List<Integer> lstFactores,String formatoDeOrden) {

        String strFactoresQuiet = "";

        List<Integer> listaDeFactores = ordenarLista(lstFactores,formatoDeOrden);

        ListIterator<Integer> itListaFactores = listaDeFactores.listIterator(lstFactores.size());

        while (itListaFactores.hasPrevious()){
            strFactoresQuiet = strFactoresQuiet + Integer.toString(itListaFactores.previous()) + "\n";
        }

        return strFactoresQuiet;
    }

    private List<Integer> ordenarLista(List<Integer> listaDeFactoresPrimos, String formatoDeOrden) {

        switch (formatoDeOrden.toUpperCase()) {
            case "--SORT:ASC":
                Collections.sort(listaDeFactoresPrimos);
                break;
            case "--SORT:DES":
                Comparator<Integer> comparador = Collections.reverseOrder();
                Collections.sort(listaDeFactoresPrimos, comparador);
                break;
            default:
                Collections.sort(listaDeFactoresPrimos);
                break;
        }

        return listaDeFactoresPrimos;
    }
}

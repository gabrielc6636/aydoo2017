package ar.edu.untref.aydoo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Comparator;

/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosImpresor {

    public String imprimirEnFormatoPretty(
            final int numeroAFactorizar,
            final List<Integer> lstFactores,
            final String formatoDeOrden) {

        String strFactoresPretty =
                "Factores primos "
                        + Integer.toString(numeroAFactorizar)
                        + ": ";

        List<Integer> listaDeFactores =
                ordenarLista(lstFactores, formatoDeOrden);

        for (Integer factor: listaDeFactores) {
            strFactoresPretty = strFactoresPretty
                    + Integer.toString(factor)
                    + ' ';
        }

        return strFactoresPretty;
    }

    public String imprimirEnFormatoQuiet(
            final List<Integer> lstFactores,
            final String formatoDeOrden) {

        String strFactoresQuiet = "";

        List<Integer> listaDeFactores =
                ordenarLista(lstFactores, formatoDeOrden);

        for (Integer factor: listaDeFactores) {
            strFactoresQuiet = strFactoresQuiet
                    + Integer.toString(factor)
                    + "\n";
        }

        return strFactoresQuiet;
    }

    private List<Integer> ordenarLista(
            final List<Integer> listaDeFactoresPrimos,
            final String formatoDeOrden) {

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

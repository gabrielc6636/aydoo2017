package ar.edu.untref.aydoo;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosImpresor {

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
}

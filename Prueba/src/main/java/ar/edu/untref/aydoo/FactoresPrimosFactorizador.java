package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosFactorizador {

    int intNumeroAFactorizar;

    public List<Integer> calcularFactores(int intNumeroAFactorizar) throws FactorizadorException {

        this.intNumeroAFactorizar = intNumeroAFactorizar;
        int intFactor = 2;
        List<Integer> lstFactores = new LinkedList<Integer>();

        if (this.intNumeroAFactorizar > 1) {
            while (this.intNumeroAFactorizar != 1 ) {
                while ( (this.intNumeroAFactorizar % intFactor) == 0)
                {
                    this.intNumeroAFactorizar /= intFactor;
                    lstFactores.add(intFactor);
                }
                intFactor++;
            }
        }
        else {
            throw new FactorizadorException("El valor debe ser mayor a 1");
        }

        return lstFactores;
    }
}

package ar.edu.untref.aydoo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by gabriel on 22/04/17.
 */
public class FactoresPrimosFactorizador {

    private int numeroAFactorizar;

    public List<Integer> calcularFactores(
            final int intNumeroAFactorizar)
            throws FactorizadorException {

        this.numeroAFactorizar = intNumeroAFactorizar;
        int intFactor = 2;
        List<Integer> lstFactores = new LinkedList<Integer>();
        if (this.numeroAFactorizar > 1) {
            while (this.numeroAFactorizar != 1) {
                while ((this.numeroAFactorizar % intFactor) == 0) {
                    this.numeroAFactorizar /= intFactor;
                    lstFactores.add(intFactor);
                }
                intFactor++;
            }
        } else {
            throw new FactorizadorException("El valor debe ser mayor a 1");
        }

        return lstFactores;
    }
}

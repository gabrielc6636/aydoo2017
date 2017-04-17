package ar.edu.untref.aydoo.club;

import org.junit.Test;

/**
 * Created by gabriel on 16/04/17.
 */
public class BeneficioTest {

    @Test(expected = BeneficioException.class)
    public void siTengo2porcientoDeDescuentoObtengoError() throws BeneficioException{
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC,2);
    }
}

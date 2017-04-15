package ar.edu.untref.aydoo.club;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by gabriel on 14/04/17.
 */
public class PruebaEstablecimiento {

    @Test
    public void siAgregoBeneficioTarjetaClassicTengoQueTenerBeneficio() throws BeneficioException {

        Establecimiento heladeria = new Establecimiento();
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC,20);

        heladeria.agregarBeneficio(beneficio);

        Beneficio beneficioObtenido = heladeria.tieneBeneficio(Tarjeta.CLASSIC);

        Assert.assertEquals(beneficio,beneficioObtenido);
    }

    @Test(expected = BeneficioException.class)
    public void siAgregoBeneficioTarjetaClassicNoTengoQueTenerBeneficioPremium() throws BeneficioException {

        Establecimiento heladeria = new Establecimiento();
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC,20);

        heladeria.agregarBeneficio(beneficio);

        Beneficio beneficioObtenido = heladeria.tieneBeneficio(Tarjeta.PREMIUM);

        Assert.assertEquals(beneficio,beneficioObtenido);
    }
}

package ar.edu.untref.aydoo.club;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class PruebaSucursal {

    @Test
    public void siJuanCompraEnLaSucursalBLaOperacionSeRegistraEnLaSucursalYEnJuan() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        Establecimiento heladeria = new Establecimiento();
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 20);
        Sucursal heladeriaSucursal1 = new Sucursal("SucursalPrueba");

        heladeria.agregarSucursal(heladeriaSucursal1);
        heladeria.agregarBeneficio(beneficio);
        
        heladeriaSucursal1.comprar(juan, 100,EnumMes.ENERO);

        List<Operacion> operacionesDeJuan = juan.getOperaciones();
        List<Operacion> operacionesDeSucursal1 = heladeriaSucursal1.getOperaciones();

        Assert.assertEquals(operacionesDeJuan.size(), 1);
        Assert.assertEquals(operacionesDeSucursal1.size(), 1);
        Assert.assertEquals(operacionesDeJuan.get(0), operacionesDeSucursal1.get(0));
    }
    
    @Test(expected = BeneficioException.class)
    public void siJuanTieneTarjetaClassicPeroLaSucursalSoloManejaTarjetaPremiumEntoncesHayUnaExcepcion() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.CLASSIC,"a@b.com");
        
        Establecimiento heladeria = new Establecimiento();
        Sucursal heladeriaSucursal1 = new Sucursal("SucursalPrueba");
        Beneficio beneficioTarjetaPremium = new Beneficio(Tarjeta.PREMIUM, 20);
        
        heladeria.agregarSucursal(heladeriaSucursal1);
        heladeria.agregarBeneficio(beneficioTarjetaPremium);

        heladeriaSucursal1.comprar(juan, 100,EnumMes.ENERO);
    }

}
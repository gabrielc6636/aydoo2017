package ar.edu.untref.aydoo.club;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class SucursalTest {

    @Test
    public void siJuanCompraEnLaSucursalBLaOperacionSeRegistraEnLaSucursalYEnJuan() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.PREMIUM,"a@b.com");

        Establecimiento heladeria = new Establecimiento("Heladeria");
        Beneficio beneficio = new Beneficio(Tarjeta.PREMIUM, 20);
        Sucursal heladeriaSucursal1 = new Sucursal("SucursalPrueba");
        Producto kiloDeHelado = new Producto(100.0,"Kilo de Helado");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(kiloDeHelado);

        heladeria.agregarSucursal(heladeriaSucursal1);
        heladeria.agregarBeneficio(beneficio);

        heladeriaSucursal1.comprar(juan, productos, Mes.ENERO);

        List<Operacion> operacionesDeJuan = juan.obtenerOperaciones();
        List<Operacion> operacionesDeSucursal1 = heladeriaSucursal1.obtenerOperaciones();

        Assert.assertEquals(operacionesDeJuan.size(), 1);
        Assert.assertEquals(operacionesDeSucursal1.size(), 1);
        Assert.assertEquals(operacionesDeJuan.get(0), operacionesDeSucursal1.get(0));
    }
    
    @Test(expected = BeneficioException.class)
    public void siJuanTieneTarjetaClassicPeroLaSucursalSoloManejaTarjetaPremiumEntoncesHayUnaExcepcion() throws BeneficioException {

        Cliente juan = new Cliente(Tarjeta.CLASSIC,"a@b.com");
        
        Establecimiento heladeria = new Establecimiento("Heladeria");
        Sucursal heladeriaSucursal1 = new Sucursal("SucursalPrueba");
        Beneficio beneficioTarjetaPremium = new Beneficio(Tarjeta.PREMIUM, 20);
        Producto kiloDeHelado = new Producto(100.0,"Kilo de Helado");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(kiloDeHelado);

        heladeria.agregarSucursal(heladeriaSucursal1);
        heladeria.agregarBeneficio(beneficioTarjetaPremium);

        heladeriaSucursal1.comprar(juan, productos, Mes.ENERO);

        List<Operacion> operacionesDeJuan = juan.obtenerOperaciones();
        Assert.assertEquals(operacionesDeJuan.size(), 1);
    }

}
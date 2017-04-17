package ar.edu.untref.aydoo.club;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ClienteTest {

    private Cliente juan;

    @Before
    public void inicializar() {
        this.juan = new Cliente(Tarjeta.CLASSIC,"a@b.com");
    }
    
    @Test
    public void siElClienteNoRealizaOperacionesEntoncesNoAhorraNada() {
       
        Assert.assertEquals(0, juan.calcularDineroAbonado(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeMilPesosConDescuentoDe10PorcientoEntoncesPago900() throws BeneficioException {
        
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);

        Producto productoTest = new Producto(1000,"Producto de Test");

        Sucursal sucursalTest = new Sucursal("SucursalTest");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);
        
        Operacion operacion = new Operacion(beneficio, productos, Mes.ENERO,sucursalTest);

        juan.registrarOperacion(operacion);
        
        Assert.assertEquals(900, juan.calcularDineroAbonado(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeUnPesoConDescuentoDe50PorcientoEntoncesAhorro1() throws BeneficioException  {
        
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 50);

        Producto productoTest = new Producto(1,"Producto de Test");

        Sucursal sucursalTest = new Sucursal("SucursalTest");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);
        
        Operacion operacion = new Operacion(beneficio, productos, Mes.ENERO,sucursalTest);

        juan.registrarOperacion(operacion);
        
        Assert.assertEquals(0.5, juan.calcularDineroAbonado(), 0.005);
    }

    @Test
    public void siElClienteRealizaUnaOperacionDeMilPesosConDescuentoDe10PorcientoEntoncesAhorro100() throws BeneficioException  {

        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);

        Producto productoTest = new Producto(1000,"Producto de Test");

        Sucursal sucursalTest = new Sucursal("SucursalTest");

        List<Producto> productos = new ArrayList<Producto>();
        productos.add(productoTest);

        Operacion operacion = new Operacion(beneficio, productos, Mes.ENERO, sucursalTest);

        juan.registrarOperacion(operacion);

        Assert.assertEquals(100, juan.calcularAhorro(Mes.ENERO), 0.005);
    }
}
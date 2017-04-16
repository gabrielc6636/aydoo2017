package ar.edu.untref.aydoo.club;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void siElClienteRealizaUnaOperacionDeMilPesosConDescuentoDe10PorcientoEntoncesPago900() {
        
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);
        
        Operacion operacion = new Operacion(beneficio, 1000, Mes.ENERO);

        juan.registrarOperacion(operacion);
        
        Assert.assertEquals(900, juan.calcularDineroAbonado(), 0.005);
    }
    
    @Test
    public void siElClienteRealizaUnaOperacionDeUnPesoConDescuentoDe50PorcientoEntoncesAhorro1() {
        
        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 50);
        
        Operacion operacion = new Operacion(beneficio, 1, Mes.ENERO);

        juan.registrarOperacion(operacion);
        
        Assert.assertEquals(0.5, juan.calcularDineroAbonado(), 0.005);
    }

    @Test
    public void siElClienteRealizaUnaOperacionDeMilPesosConDescuentoDe10PorcientoEntoncesAhorro100() {

        Beneficio beneficio = new Beneficio(Tarjeta.CLASSIC, 10);

        Operacion operacion = new Operacion(beneficio, 1000, Mes.ENERO);

        juan.registrarOperacion(operacion);

        Assert.assertEquals(100, juan.calcularAhorro(Mes.ENERO), 0.005);
    }
}